#include <string>
#include <vector>

using namespace std;

class TrieNode {
 public:
  TrieNode *child[26];
  bool isWord;
  TrieNode() : isWord(false) {
    for (auto &a : child) {
      a = NULL;
    }
  }
};

class StreamChecker {
 public:
  StreamChecker(vector<string>& words) {
    buildTree(words);
  }
    
  bool query(char letter) {
    queries.push_back(letter);
    TrieNode* p = root;
    for (int i = queries.size() - 1; i >= 0 && p; i--) {
      char c = queries[i];
      p = p->child[c - 'a'];
      if (p && p->isWord) {
        return true;
      }
    }
    return false;
  }

 private:
  TrieNode* root;
  vector<char> queries;

  void buildTree(vector<string>& words) {
    root = new TrieNode();
    for (string& w : words) {
      TrieNode* p = root;
      for (int i = w.size() - 1; i >= 0; i--) {
        int c = w[i] - 'a';
        if (!p->child[c]) {
            p->child[c] = new TrieNode();
        }
        p = p->child[c];
      }
      p->isWord = true;
    }
  }
};
