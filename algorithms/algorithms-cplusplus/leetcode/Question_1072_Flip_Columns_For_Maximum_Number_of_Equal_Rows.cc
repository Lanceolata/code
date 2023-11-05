#include <vector>

using namespace std;

class Solution {
 public:
  int maxEqualRowsAfterFlips(vector<vector<int>>& matrix) {
    int res = 0, m = matrix.size(), n = matrix[0].size();
    for(int i = 0; i < m; i++) {
      int cnt = 0;
      vector<int> flip(n);
      for(int j = 0; j < n; j++) {
        flip[j] = 1 - matrix[i][j];
      }
      for(int k = i; k < m; k++) {
        if (matrix[k] == matrix[i] || matrix[k] == flip) {
          cnt++;
        }
      }
      res = max(res, cnt);
    }
    return res;
  }
};
