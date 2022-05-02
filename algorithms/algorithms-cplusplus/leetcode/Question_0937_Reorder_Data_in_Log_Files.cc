#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  vector<string> reorderLogFiles(vector<string>& logs) {
    vector<string> digitLogs, res;
    vector<pair<string, string>> letterLogs;
    for (string &s : logs) {
      int i = 0;
      while (s[i] != ' ') {
        ++i;
      }
      if (isalpha(s[i + 1])) {
        letterLogs.emplace_back(s.substr(0, i), s.substr(i + 1));
      } else {
        digitLogs.push_back(s);
      }
    }
    sort(letterLogs.begin(), letterLogs.end(), [&](pair<string, string>& a, pair<string, string>& b) {
        return a.second == b.second ? a.first < b.first : a.second < b.second;
    });
    for (auto &p : letterLogs) {
      res.push_back(p.first + " " + p.second);
    }
    for (string &s : digitLogs) {
      res.push_back(s);
    }
    return res;
  }
};
