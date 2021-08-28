#include <vector>

using namespace std;

class Solution {
 public:
  int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
    if (m <= 0 || n <= 0) {
      return 0;
    }
    int mod = 1000000007;
    vector<vector<int>> dp(m, vector<int>(n, 0));
    for (int move = 0; move < maxMove; move++) {
      vector<vector<int>> tmp(m, vector<int>(n, 0)); 
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          long long count = 0;
          count += i == 0 ? 1 : dp[i - 1][j];
          count += i == m - 1 ? 1 : dp[i + 1][j];
          count += j == 0 ? 1 : dp[i][j - 1];
          count += j == n - 1 ? 1 : dp[i][j + 1];
          tmp[i][j] = count % mod;
        }
      }
      dp = tmp;
    }
    return dp[startRow][startColumn];
  }
};
