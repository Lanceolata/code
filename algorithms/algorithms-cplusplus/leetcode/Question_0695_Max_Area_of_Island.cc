#include <vector>
#include <algorithm>

using namespace std;

class Solution {
 public:
  int maxAreaOfIsland(vector<vector<int>>& grid) {
    int m = grid.size(), n = grid[0].size();
    vector<vector<bool>> visited(m, vector<bool>(n, false));
    int res = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (visited[i][j] || grid[i][j] == 0) {
          continue;
        }
        res = max(res, help(grid, i, j, visited));
      }
    }
    return res;
  }

  int help(vector<vector<int>>& grid, int r, int c, vector<vector<bool>>& visited) {
    if (r < 0 || r >= grid.size() || c < 0 || c >= grid[0].size()) {
      return 0;
    }
    if (visited[r][c] || grid[r][c] == 0) {
      return 0;
    }
    visited[r][c] = true;
    int res = 1;
    res += help(grid, r - 1, c, visited);
    res += help(grid, r + 1, c, visited);
    res += help(grid, r, c - 1, visited);
    res += help(grid, r, c + 1, visited);
    return res;
  }
};
