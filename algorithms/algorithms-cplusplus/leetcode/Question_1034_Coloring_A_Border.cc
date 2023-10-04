#include <vector>

using namespace std;

class Solution {
 public:
  vector<vector<int>> colorBorder(vector<vector<int>>& grid, int row, int col, int color) {
    int m = grid.size(), n = grid[0].size();
    if (grid[row][col] == color) {
      return grid;
    }
    vector<vector<bool>> visited(m, vector<bool>(n, false));
    dfs(grid, row, col, grid[row][col], visited, color);
    return grid;
  }

  void dfs(vector<vector<int>>& grid, int r, int c, int color, vector<vector<bool>>& visited, int target) {
    if (r < 0 || r >= grid.size() || c < 0 || c >= grid[0].size()) {
      return;
    }
    if (grid[r][c] != color || visited[r][c]) {
      return;
    }
    visited[r][c] = true;
    bool border = false;
    if (r == 0 || r == grid.size() - 1 || c == 0 || c == grid[0].size() - 1
        || grid[r + 1][c] != color || grid[r - 1][c] != color
        || grid[r][c + 1] != color || grid[r][c - 1] != color) {
      border = true;
    }
    dfs(grid, r + 1, c, color, visited, target);
    dfs(grid, r - 1, c, color, visited, target);
    dfs(grid, r, c + 1, color, visited, target);
    dfs(grid, r, c - 1, color, visited, target);
    if (border) {
      grid[r][c] = target;
    }
  }
};
