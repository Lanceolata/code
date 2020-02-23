#include <vector>

using namespace std;

class Solution {
 public:
  void rotate(vector<vector<int>>& matrix) {
    int n = matrix.size();
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        swap(matrix[i][j], matrix[j][i]);
      }
      reverse(matrix[i]);
    }
  }

  void reverse(vector<int>& nums) {
    int l = 0, r = nums.size() - 1;
    while (l < r) {
      swap(nums[l], nums[r]);
      l++; r--;
    }
  }
};
