#include <vector>

using namespace std;

class Solution {
 public:
  int numberOfArithmeticSlices1(vector<int>& nums) {
    int sum = 0;
    slices(nums, nums.size() - 1, sum);
    return sum;
  }

  int slices(vector<int>& nums, int i, int& sum) {
    if (i < 2) {
      return 0;
    }
    int ap = 0;
    if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
      ap = 1 + slices(nums, i - 1, sum);
      sum += ap;
    } else {
      slices(nums, i - 1, sum);
    }
    return ap;
  }

  int numberOfArithmeticSlices2(vector<int>& nums) {
    int res = 0, n = nums.size();
    vector<int> dp(n, 0);
    for (int i = 2; i < n; ++i) {
      if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
        dp[i] = dp[i - 1] + 1;
      }
      res += dp[i];
    }
    return res;
  }

  int numberOfArithmeticSlices(vector<int>& nums) {
    int res = 0, cur = 0;
    for (int i = 2; i < nums.size(); ++i) {
      if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
        cur += 1;
        res += cur;
      } else {
        cur = 0;
      }
    }
    return res;
  }
};
