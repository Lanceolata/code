#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  bool isMatch(string s, string p) {
    if (p.empty()) {
      return s.empty();
    }
    vector<vector<bool> > dp(s.size() + 1, vector<bool>(p.size() + 1, false));
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
};
