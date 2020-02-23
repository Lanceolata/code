#include <vector>

using namespace std;

class Solution {
 public:
  int maximalSquare(vector<vector<char>>& matrix) {
    if (matrix.empty() || matrix[0].empty()) {
      return 0;
    }
    int m = matrix.size(), n = matrix[0].size(), res = 0, pre = 0;
    vector<int> dp(n + 1, 0);
    for (int i = 0; i < m; i++) {
      for (int j = 1; j <= n; j++) {
        int tmp = dp[j];
        if (matrix[i][j - 1] == '1') {
          dp[j] = min(dp[j], min(dp[j - 1], pre)) + 1;
          res = max(res, dp[j]);
        } else {
          dp[j] = 0;
        }
        pre = tmp;
      }
    }
    return res * res;
  }
};
