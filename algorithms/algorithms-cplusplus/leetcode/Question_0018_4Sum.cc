#include <vector>
#include <algorithm>

using namespace std;

class Solution {
 public:
  vector<vector<int>> fourSum(vector<int>& nums, int target) {
    vector<vector<int>> res;
    if (nums.size() < 4) {
      return res;
    }
    sort(nums.begin(), nums.end());
    for (size_t m = 0; m < nums.size() - 3; m++) {
      if (m > 0 && nums[m] == nums[m - 1]) {
        continue;
      }
      for (size_t n = m + 1; n < nums.size() - 2; n++) {
        if (n > m + 1 && nums[n] == nums[n - 1]) {
          continue;
        }
        size_t l = n + 1, r = nums.size() - 1;
        while (l < r) {
          int sum = nums[m] + nums[n] + nums[l] + nums[r];
          if (sum == target) {
            vector<int> tmp = {nums[m], nums[n], nums[l], nums[r]};
            res.push_back(tmp);
            while (l < r && nums[l] == nums[l + 1]) {
              ++l;
            }
            while (l < r && nums[r] == nums[r - 1]) {
              --r;
            }
            ++l; --r;
          } else if (sum < target) {
            ++l;
          } else {
            --r;
          }
        }
      }
    }
    return res;
  }
};
