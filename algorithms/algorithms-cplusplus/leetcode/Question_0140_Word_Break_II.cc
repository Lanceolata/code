#include <string.h>
#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
 public:
  vector<string> wordBreak(string s, vector<string>& wordDict) {
    unordered_map<string, vector<string>> m;
    return dfs(s, wordDict, m);
  }

  vector<string> dfs(string s, vector<string>& wordDict, unordered_map<string, vector<string>>& m) {
    if (m.count(s)) return m[s];

    vector<string> vec;
    if (s.empty()) {
      vec.push_back("");
      return vec;
    }

    for (string& word : wordDict) {
      if (word.size() > s.size()) continue;
      if (strncmp(s.c_str(), word.c_str(), word.size()) == 0) {
        vector<string> sub = dfs(s.substr(word.size()), wordDict, m);
        for (string& w : sub) {
          if (w.empty()) vec.push_back(word);
          else vec.push_back(word + " " + w);
        }
      }
    }
    m[s] = vec;
    return vec;
  }
};
