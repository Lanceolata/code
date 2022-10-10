#include <string>
#include <vector>

using namespace std;

class TrieNode {
 public:
  TrieNode *child[26];
  bool isWord;
  string* word;
  TrieNode() : isWord(false) {
    for (auto &a : child) a = NULL;
    word = NULL;
  }
};

class Solution {
 public:
  vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
    vector<string> res;
    TrieNode* root = buildTrie(words);
    for (int i = 0; i < board.size(); i++) {
      for (int j = 0; j < board[0].size(); j++) {
        dfs(board, i, j, root, res);
      }
    }
    return res;
  }

 private:
  TrieNode* buildTrie(vector<string>& words) {
    TrieNode* root = new TrieNode();
    for (string& w : words) {
      TrieNode* p = root;
      for (char c : w) {
        if (!p->child[c - 'a']) {
          p->child[c - 'a'] = new TrieNode();
        }
        p = p->child[c - 'a'];
      }
      p->isWord = true;
      p->word = &w;
    }
    return root;
  }

  void dfs(vector<vector<char>>& board, int i, int j, TrieNode* p, vector<string>& res) {
    if (i < 0 || i >= board.size() || j < 0 || j >= board[0].size()) {
      return;
    }
    char c = board[i][j];
    if (c == '#' || !p->child[c - 'a']) {
      return;
    }
    p = p->child[c - 'a'];
    if (p->isWord) {
      res.push_back(*p->word);
      p->isWord = false;
    }
    board[i][j] = '#';
    dfs(board, i - 1, j, p, res);
    dfs(board, i + 1, j, p, res);
    dfs(board, i, j - 1, p, res);
    dfs(board, i, j + 1, p, res);
    board[i][j] = c;
  }
};
