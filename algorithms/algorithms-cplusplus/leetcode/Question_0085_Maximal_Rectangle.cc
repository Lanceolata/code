#include <vector>

using namespace std;

class Solution {
 public:
  int maximalRectangle(vector<vector<char>>& matrix) {
    if(matrix.empty()) {
      return 0;
    }
    int m = matrix.size(), n = matrix[0].size();
    vector<int> left(n, 0), right(n, n), height(n ,0);
    int res = 0;
    for (int i = 0; i < m; i++) {
      int cur_left=0, cur_right=n;
      // 上边界是1的长度
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == '1') {
          height[j]++;
        } else {
          height[j] = 0;
        }
      }
      // 左边界是1的长度
      for (int j = 0; j < n; j++) {
        if(matrix[i][j] == '1') {
          left[j] = max(left[j],cur_left);
        } else {
          left[j] = 0;
          cur_left = j+1;
        }
      }
      // 右边界是1的长度
      for (int j = n - 1; j >= 0; j--) {
        if(matrix[i][j] == '1') {
          right[j] = min(right[j], cur_right);
        } else {
          right[j] = n;
          cur_right = j;
        }
      }
      for (int j = 0; j < n; j++) {
        res = max(res, (right[j] - left[j]) * height[j]);
      }
    }
    return res;
  }
};
