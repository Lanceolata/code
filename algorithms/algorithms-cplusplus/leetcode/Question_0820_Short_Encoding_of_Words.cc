#include <string>
#include <vector>

using namespace std;

struct TrieNode {
  vector<TrieNode*> children;
  int count;
};

class Solution {
 public:
  int minimumLengthEncoding(vector<string>& words) {
    TrieNode *root = new TrieNode(), *cur;
    root->children.resize(26);
    for (string& w : words) {
      cur = root;
      for (int i = w.size() - 1; i >= 0; i--) {
        if (!cur->children[w[i] - 'a']) {
          cur->children[w[i] - 'a'] = new TrieNode();
          (cur->children[w[i] - 'a'])->children.resize(26);
          cur->count++;
        }
        cur = cur->children[w[i] - 'a'];
      }
    }
    return help(root, 0);
  }

 private:
  int help(TrieNode *root, int len) {
    if (root->count == 0) {
      return len + 1;
    }
    int res = 0;
    for (TrieNode *cur : root->children) {
      if (cur) {
        res += help(cur, len + 1);
      }
    }
    return res;
  }
};
