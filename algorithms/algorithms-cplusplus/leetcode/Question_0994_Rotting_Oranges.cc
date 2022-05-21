#include <vector>

using namespace std;

class Solution {
 public:
  int orangesRotting(vector<vector<int>>& grid) {
    int m = grid.size(), n = grid[0].size();
    vector<vector<int>> vec(m, vector<int>(n, -1));
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 2) {
          bfs(grid, i, j, 0, vec);
        }
      }
    }
    int res = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1 && vec[i][j] == -1) {
          return -1;
        }
        res = max(res, vec[i][j]);
      }
    }
    return res;
  }

 private:
  void bfs(vector<vector<int>>& grid, int r, int c, int n, vector<vector<int>>& vec) {
    if (r < 0 || r >= grid.size() || c < 0 || c >= grid[0].size() || grid[r][c] == 0) {
      return;
    }
    if (vec[r][c] >= 0 && vec[r][c] <= n) {
      return;
    }
    vec[r][c] = n;
    bfs(grid, r - 1, c, n + 1, vec);
    bfs(grid, r + 1, c, n + 1, vec);
    bfs(grid, r, c - 1, n + 1, vec);
    bfs(grid, r, c + 1, n + 1, vec);
  }
};
