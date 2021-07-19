#include <vector>

using namespace std;

class Solution {
 public:
  vector<int> findDiagonalOrder(vector<vector<int>>& mat) {
    if (mat.empty() || mat[0].empty()) {
      return {};
    }
    int m = mat.size(), n = mat[0].size(), k = 0;
    vector<int> res(m * n);
    for (int i = 0; i < m + n - 1; ++i) {
      int low = max(0, i - n + 1), high = min(i, m - 1);
      if (i % 2 == 0) {
        for (int j = high; j >= low; --j) {
          res[k++] = mat[j][i - j];
        }
      } else {
        for (int j = low; j <= high; ++j) {
          res[k++] = mat[j][i - j];
        }
      }
    }
    return res;
  }
};
