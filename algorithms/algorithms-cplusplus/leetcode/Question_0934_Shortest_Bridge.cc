#include <vector>
#include <queue>

using namespace std;

class Solution {
 public:
  int shortestBridge(vector<vector<int>>& grid) {
    int m = grid.size(), n = grid[0].size();
    vector<vector<bool>> visited(m, vector<bool>(n, false));
    vector<vector<int>> dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    queue<pair<int, int>> q;
    bool found = false;
    for (int i = 0; i < m && !found; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          dfs(grid, visited, q, i, j, dirs);
          found = true;
          break;
        }
      }
    }
    int step = 0;
    while (!q.empty()) {
      for (int size = q.size(); size > 0; size--) {
        pair<int, int> cur = q.front();
        q.pop();
        for (vector<int>& dir : dirs) {
          int i = cur.first + dir[0];
          int j = cur.second + dir[1];
          if (i >= 0 && j >= 0 && i < m && j < n && !visited[i][j]) {
            if (grid[i][j] == 1) {
              return step;
            }
            q.push({i, j});
            visited[i][j] = true;
          }
        }
      }
      step++;
    }
    return -1;
  }

 private:
  void dfs(vector<vector<int>>& grid, vector<vector<bool>>& visited, queue<pair<int, int>>& q, int i, int j, vector<vector<int>>& dirs) {
    if (i < 0 || j < 0 || i >= grid.size() || j >= grid[0].size() || visited[i][j] || grid[i][j] == 0) {
      return;
    }
    visited[i][j] = true;
    q.push({i, j});
    for (vector<int>& dir : dirs) {
      dfs(grid, visited, q, i + dir[0], j + dir[1], dirs);
    }
  }
};
