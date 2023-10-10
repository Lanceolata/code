#include <vector>

using namespace std;

class Solution {
 public:
  int minScoreTriangulation(vector<int>& values) {
    int n = values.size();
    vector<vector<int>> dp(n, vector<int>(n));
    for (int j = 2; j < n; ++j) {
      for (int i = j - 2; i >= 0; --i) {
        dp[i][j] = INT_MAX;
        for (int k = i + 1; k < j; ++k) {
          dp[i][j] = min(dp[i][j], dp[i][k] + dp[k][j] + values[i] * values[j] * values[k]);
        }
      }
    }
    return dp[0][n - 1];
  }
};
