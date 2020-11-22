#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  bool isMatch(string s, string p) {
    if (p.empty()) {
      return s.empty();
    }
    vector<vector<bool>> dp(s.size() + 1, vector<bool>(p.size() + 1, false));
    dp[s.size()][p.size()] = true;
    for (int i = s.size(); i >= 0; i--) {
      for (int j = p.size() - 1; j >= 0; j--) {
        bool match = i < s.size() && (s[i] == p[j] || p[j] == '.');
        if (j + 1 < p.size() && p[j + 1] == '*') {
          dp[i][j] = dp[i][j + 2] || (match && dp[i + 1][j]);
        } else {
          dp[i][j] = match && dp[i + 1][j + 1];
        }
      }
    }
    return dp[0][0];
  }

  bool isMatch_recursion(string s, string p) {
    if (p.empty()) {
      return s.empty();
    }
    return help(s, p, 0, 0);
  }

  bool help(string s, string p, int i, int j) {
    if (j >= p.size()) {
      return i >= s.size();
    }
    bool match = i < s.size() && (s[i] == p[j] || p[j] == '.');
    if (j + 1 < p.size() && p[j + 1] == '*') {
      return help(s, p, i, j + 2) || (match && help(s, p, i + 1, j));
    } else {
      return match && help(s, p, i + 1, j + 1);
    }
  }
};
