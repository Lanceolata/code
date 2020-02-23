#include <vector>

using namespace std;

class Solution {
 public:
  int longestIncreasingPath(vector<vector<int>>& matrix) {
    if (matrix.empty() || matrix[0].empty()) {
      return 0;
    }
    int m = matrix.size(), n = matrix[0].size();
    vector<vector<int>> dp(m, vector<int>(n, 0));
    int res = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        res = max(res, help(matrix, dp, i, j));
      }
    }
    return res;
  }

  vector<vector<int>> dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

  int help(vector<vector<int>>& matrix, vector<vector<int>>& dp, int i, int j) {
    if (dp[i][j]) {
      return dp[i][j];
    }
    int res = 1, m = matrix.size(), n = matrix[0].size();
    for (vector<int>& dir : dirs) {
      int r = i + dir[0], c = j + dir[1];
      if (r < 0 || r >= m || c < 0 || c >= n || matrix[r][c] <= matrix[i][j]) {
        continue;
      }
      int len = help(matrix, dp, r, c) + 1;
      res = max(res, len);
    }
    dp[i][j] = res;
    return res;
  }
};
