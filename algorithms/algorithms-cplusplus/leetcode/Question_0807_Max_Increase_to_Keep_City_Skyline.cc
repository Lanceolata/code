#include <vector>

using namespace std;

class Solution {
 public:
  int maxIncreaseKeepingSkyline(vector<vector<int>>& grid) {
    int n = grid.size();
    vector<int> rowMaxes(n), colMaxes(n);
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < n; ++c) {
        rowMaxes[r] = max(rowMaxes[r], grid[r][c]);
        colMaxes[c] = max(colMaxes[c], grid[r][c]);
      }
    }
    int res = 0;
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < n; ++c) {
        res += min(rowMaxes[r], colMaxes[c]) - grid[r][c];
      }
    }
    return res;
  }
};
