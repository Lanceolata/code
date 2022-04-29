#include <vector>

using namespace std;

class Solution {
 public:
  vector<int> sortArrayByParityII(vector<int>& nums) {
    int n = nums.size(), i = 0, j = nums.size() - 1;
    while (i < n && j >= 0) {
      while (i < n && (nums[i] & 1) == 0) {
        i += 2;
      }
      while (j >= 0 && (nums[j] & 1) == 1) {
        j -= 2;
      }
      if (i < n && j >= 0) {
        swap(nums[i], nums[j]);
        i += 2;
        j -= 2;
      }
    }
    return nums;
  }
};
