#include <vector>

using namespace std;

class Solution {
 public:
  int matrixScore(vector<vector<int>>& grid) {
    int m = grid.size(), n = grid[0].size(), res = (1 << (n - 1)) * m;
    for (int j = 1; j < n; j++) {
      int cur = 0;
      for (int i = 0; i < m; i++) {
        cur += grid[i][j] == grid[i][0];
      }
      res += max(cur, m - cur) * (1 << (n - j - 1));
    }
    return res;
  }
};
