#include <vector>

using namespace std;

class Solution {
 public:
  int kthSmallest(vector<vector<int>>& matrix, int k) {
    int l = matrix[0][0], r = matrix[matrix.size() - 1][matrix[0].size() - 1] + 1, m;
    while (l <= r) {
      m = l + (r - l) / 2;
      int cnt = help(matrix, m);
      if (cnt < k) {
        l = m + 1;
      } else {
        r = m - 1;
      }
    }
    return l;
  }

  int help(vector<vector<int>>& matrix, int n) {
    int res = 0;
    for (int i = 0; i < matrix.size(); i++) {
      int j = matrix[0].size() - 1;
      while (j >= 0 && matrix[i][j] > n) {
        j--;
      }
      res += j + 1;
    }
    return res;
  }
};
