#include <vector>

using namespace std;

class Solution {
 public:
  bool searchMatrix(vector<vector<int>>& matrix, int target) {
    if (matrix.empty() || matrix[0].empty()) {
      return false;
    }
    int m = matrix.size(), n = matrix[0].size();
    int i = 0, j = n - 1;
    while (i < m && j >= 0) {
      int v = matrix[i][j];
      if (v == target) {
        return true;
      } else if (v < target) {
        i++;
      } else {
        j--;
      }
    }
    return false;
  }
};
