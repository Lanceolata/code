#include <vector>

using namespace std;

class Solution {
 public:
  int thirdMax(vector<int>& nums) {
    if (nums.size() == 1) {
      return nums[0];
    }
    if (nums.size() == 2) {
      return nums[0]>nums[1] ? nums[0] : nums[1];
    }
    long num1 = LONG_MIN, num2 = LONG_MIN, num3 = LONG_MIN;

    for (size_t i = 0; i < nums.size(); i++) {
      if (nums[i] == num1 || nums[i] == num3 || nums[i] == num2) {
        continue;
      }
      if (nums[i] > num1) {
        num3 = num2;
        num2 = num1;
        num1 = nums[i];
      } else if (nums[i] > num2) {
        num3 = num2;
        num2 = nums[i];
      } else if (nums[i] > num3) {
        num3 = nums[i];
      }
    }
    return num3 == LONG_MIN ? (int)num1 : (int)num3;
  }
};
