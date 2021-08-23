#include <vector>

using namespace std;

class Solution {
 public:
  vector<vector<int>> matrixReshape(vector<vector<int>>& mat, int r, int c) {
    int m = mat.size(), n = mat[0].size();
    if (m * n != r * c || (m == r && n == c)) {
      return mat;
    }
    vector<vector<int>> res(r, vector<int>(c, 0)); 
    int rr = 0, cc = 0;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            res[rr][cc++] = mat[i][j];
            if (cc >= c) {
              rr++;
              cc = 0;
            }
        }
    }
    return res;
  }
};
