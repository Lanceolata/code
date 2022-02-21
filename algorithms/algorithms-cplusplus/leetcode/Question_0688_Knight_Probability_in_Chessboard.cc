#include <vector>
#include <iostream>

using namespace std;

class Solution {
 public:
  double knightProbability(int n, int k, int row, int column) {
    vector<vector<double>> dp(n, vector<double>(n, 0.0));
    vector<int> mr = {2, 2, 1, 1, -1, -1, -2, -2}, mc = {1, -1, 2, -2, 2, -2, 1, -1};
    dp[row][column] = 1.0;
    for (; k > 0; k--) {
      vector<vector<double>> dp2(n, vector<double>(n, 0.0));
      for (int r = 0; r < n; r++) {
        for (int c = 0; c < n; c++) {
          for (int i = 0; i < 8; i++) {
            int nr = r + mr[i];
            int nc = c + mc[i];
            if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
              dp2[nr][nc] += dp[r][c] / 8.0;
            }
          }
        }
      }
      dp = dp2;
    }
    double res = 0.0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        res += dp[i][j];
      }
    }
    return res;
  }
};
