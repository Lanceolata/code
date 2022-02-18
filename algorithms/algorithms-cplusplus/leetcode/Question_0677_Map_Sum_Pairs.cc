#include <string>
#include <unordered_map>

using namespace std;

struct TrieNode {
  unordered_map<char, TrieNode*> children;
  int score;
};

class MapSum {
 public:
  MapSum() {
  }
    
  void insert(string key, int val) {
    int delta = val - m[key];
    m[key] = val;
    TrieNode *cur = root;
    cur->score += delta;
    for (char c : key) {
      if (cur->children.find(c) == cur->children.end()) {
        cur->children[c] = new TrieNode();
      }
      cur = cur->children[c];
      cur->score += delta;
    }
  }
    
  int sum(string prefix) {
    TrieNode *cur = root;
    for (char c : prefix) {
      if (cur->children.find(c) == cur->children.end()) {
        return 0;
      }
      cur = cur->children[c];
    }
    return cur->score;
  }

 private:
  unordered_map<string, int> m;
  TrieNode *root = new TrieNode();
};
