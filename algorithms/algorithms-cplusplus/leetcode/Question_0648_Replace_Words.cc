#include <string>
#include <vector>
#include <sstream>
#include <iostream>

using namespace std;

struct TrieNode {
  TrieNode* children[26] = {};
  bool isWord = false;
};

class Solution {
 public:
  string replaceWords(vector<string>& dictionary, string sentence) {
    TrieNode root;
    for (string s : dictionary) {
      TrieNode* cur = &root;
      for (char c : s) {
        if (!cur->children[c - 'a']) {
          cur->children[c - 'a'] = new TrieNode();
        }
        cur = cur->children[c - 'a'];
      }
      cur->isWord = true;
    }
    string res = "";
    string token;
    stringstream ss(sentence);
    while (getline(ss, token, ' ')) {
      TrieNode* cur = &root;
      int i = 0;
      for (; i < token.size(); i++) {
        if (!cur->children[token[i] - 'a'] || cur->isWord) {
          break;
        }
        cur = cur->children[token[i] - 'a'];
      }
      res += cur->isWord ? token.substr(0, i) : token;
      res += " ";
    }
    return res.substr(0, res.size() - 1);
  }
};
