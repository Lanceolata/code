#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
 public:
  vector<string> findAndReplacePattern(vector<string>& words, string pattern) {
    vector<string> res;
    for (string w : words) {
      if (help(w, pattern)) {
        res.push_back(w);
      }
    }
    return res;
  }

 private:
  bool help(string& w, string& p) {
    unordered_map<char, char> m;
    for (int i = 0; i < w.size(); i++) {
      if (!m.count(w[i])) {
        m[w[i]] = p[i];
      } else {
        if (m[w[i]] != p[i]) {
          return false;
        }
      }
    }
    vector<bool> visited(26, false);
    for (auto& c : m) {
      if (visited[c.second - 'a']) {
        return false;
      }
      visited[c.second - 'a'] = true;
    }
    return true;
  }
};
