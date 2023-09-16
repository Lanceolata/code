#include <vector>

using namespace std;

class Solution {
 public:
  int numEnclaves(vector<vector<int>>& grid) {
    int res = 0;
    vector<vector<bool>> visited(grid.size(), vector<bool>(grid[0].size(), false));
    for (int r = 1; r < grid.size() - 1; r++) {
      for (int c = 1; c < grid[0].size() - 1; c++) {
        int v = help(grid, r, c, visited);
        if (v > 0) {
          res += v;
        }
      }
    }
    return res;
  }

  int help(vector<vector<int>>& grid, int r, int c, vector<vector<bool>>& visited) {
    if (r < 0 || r >= grid.size() || c < 0 || c >= grid[0].size()) {
      return -1;
    }
    if (visited[r][c] || grid[r][c] == 0) {
      return 0;
    }
    visited[r][c] = true;
    int v1 = help(grid, r + 1, c, visited);
    int v2 = help(grid, r - 1, c, visited);
    int v3 = help(grid, r, c + 1, visited);
    int v4 = help(grid, r, c - 1, visited);
    if (v1 < 0 || v2 < 0 || v3 < 0 || v4 < 0) {
      return -1;
    }
    return v1 + v2 + v3 + v4 + 1;
  }
};
