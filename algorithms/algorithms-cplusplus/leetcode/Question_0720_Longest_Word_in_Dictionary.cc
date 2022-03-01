#include <string>
#include <vector>

using namespace std;

class TrieNode {
 public:
  TrieNode *child[26];
  bool isWord;
  string word;
  TrieNode() : isWord(false), word("") {
    for (auto &a : child) {
      a = NULL;
    }
  }
};

class Solution {
 public:
  string longestWord(vector<string>& words) {
    TrieNode *root = new TrieNode();
    for (string& w : words) {
      buildTree(w, root);
    }
    string res = "";
    dfs(root, 0, res);
    return res;
  }

 private:
  void buildTree(string& word, TrieNode *root) {
    TrieNode *p = root, *next;
    for (char c : word) {
      if (!p->child[c - 'a']) {
        p->child[c - 'a'] = new TrieNode();
      }
      p = p->child[c - 'a'];
    }
    p->isWord = true;
    p->word = word;
  }

  void dfs(TrieNode *root, int cnt, string& res) {
    cnt++;
    for (TrieNode *p : root->child) {
      if (!p || !p->isWord) {
        continue;
      }
      if (cnt > res.size()) {
        res = p->word;
      }
      dfs(p, cnt, res);
    }
  }
};
