#include <limits.h>
#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  int minFlipsMonoIncr(string s) {
    int n = s.size();
    vector<int> dp(n + 1, 0);
    for (int i = 0; i < n; ++i) {
      dp[i + 1] = dp[i] + (s[i] == '1' ? 1 : 0);
    }
    int res = INT_MAX;
    for (int j = 0; j <= n; ++j) {
      res = min(res, dp[j] + n - j - (dp[n] - dp[j]));
    }
    return res;
  }
};
