#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  int numDistinct(string s, string t) {
    size_t m = t.size(), n = s.size();
    vector<vector<long>> dp(m + 1, vector<long>(n + 1, 0));
    for (size_t j = 0; j <= n; j++) {
      dp[0][j] = 1;
    }
    for (size_t i = 1; i <= m; i++) {
      for (size_t j = 1; j <= n; j++) {
        dp[i][j] = dp[i][j - 1] + (t[i - 1] == s[j - 1] ? dp[i - 1][j - 1] : 0);
      }
    }
    return (int)dp[m][n];
  }
};
