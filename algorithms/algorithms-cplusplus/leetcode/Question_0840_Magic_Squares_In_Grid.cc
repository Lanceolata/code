#include <vector>

using namespace std;

class Solution {
 public:
  int numMagicSquaresInside(vector<vector<int>>& grid) {
    int m = grid.size(), n = grid[0].size(), res = 0;
    for (int i = 0; i < m - 2; ++i) {
      for (int j = 0; j < n - 2; ++j) {
        if (grid[i + 1][j + 1] == 5 && isValid(grid, i, j)) {
          ++res;
        }
      }
    }
    return res;
  }

 private:
  bool isValid(vector<vector<int>>& grid, int r, int c) {
    vector<bool> visited(10, false);
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        int k = grid[r + i][c + j];
        if (k < 1 || k > 9 || visited[k]) {
          return false;
        }
        visited[k] = true;
      }
    }
    if ((15 != grid[r][c] + grid[r][c + 1] + grid[r][c + 2])
        || (15 != grid[r + 1][c] + grid[r + 1][c + 1] + grid[r + 1][c + 2])
        || (15 != grid[r + 2][c] + grid[r + 2][c + 1] + grid[r + 2][c + 2])
        || (15 != grid[r][c] + grid[r + 1][c] + grid[r + 2][c])
        || (15 != grid[r][c + 1] + grid[r + 1][c + 1] + grid[r + 2][c + 1])
        || (15 != grid[r][c + 2] + grid[r + 1][c + 2] + grid[r + 2][c + 2])
        || (15 != grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2])
        || (15 != grid[r + 2][c] + grid[r + 1][c + 1] + grid[r][c + 2])) {
      return false;
    }
    return true;
  }
};
