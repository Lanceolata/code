#include <vector>

using namespace std;

class Solution {
 public:
  void nextPermutation(vector<int>& nums) {
    if (nums.size() < 2) {
      return;
    }
    int i = nums.size() - 2;
    // 找到第一个比后一个数小的数
    while (i >= 0 && nums[i + 1] <= nums[i]) {
      i--;
    }
    if (i >= 0) {
      int j = nums.size() - 1;
      // 找到第一个大于nums[i]的数
      while (j >= 0 && nums[j] <= nums[i]) {
        j--;
      }
      swap(nums[i], nums[j]);
    }
    reverse(nums, i + 1);
  }

  void reverse(vector<int>& nums, int l) {
    int r = nums.size() - 1;
    while (l < r) {
      swap(nums[l++], nums[r--]);
    }
  }
};
