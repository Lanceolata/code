#include <vector>

using namespace std;

class Solution {
 public:
  bool searchMatrix(vector<vector<int>>& matrix, int target) {
    if (matrix.empty() || matrix[0].empty()) {
      return false;
    }
    int m = matrix.size(), n = matrix[0].size();
    int row = m - 1, col = 0;
    while (row >= 0 && col < n) {
      int v = matrix[row][col];
      if (v > target) {
        row--;
      } else if (v < target) {
        col++;
      } else {
        return true;
      }
    }
    return false;
  }
};
