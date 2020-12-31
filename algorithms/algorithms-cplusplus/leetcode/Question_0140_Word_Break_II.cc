#include <string.h>
#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
 public:
  vector<string> wordBreak(string s, vector<string>& wordDict) {
    unordered_map<string, vector<string>> m;
    return help(s, wordDict, m);
  }

  vector<string> help(string s, vector<string>& wordDict, unordered_map<string, vector<string>>& m) {
    if (m.count(s)) {
      return m[s];
    }
    vector<string> res;
    if (s.empty()) {
      res.push_back("");
      return res;
    }
    for (string& word : wordDict) {
      if (word.size() > s.size()) {
        continue;
      }
      if (strncmp(s.c_str(), word.c_str(), word.size()) == 0) {
        vector<string> sub = help(s.substr(word.size()), wordDict, m);
        for (string& w : sub) {
          if (w.empty()) {
            res.push_back(word);
          } else {
            res.push_back(word + " " + w);
          }
        }
      }
    }
    m[s] = res;
    return res;
  }
};
