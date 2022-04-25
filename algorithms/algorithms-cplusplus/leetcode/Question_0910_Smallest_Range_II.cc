#include <vector>

using namespace std;

class Solution {
 public:
  int smallestRangeII(vector<int>& nums, int k) {
    sort(nums.begin(), nums.end());
    int n = nums.size(), mx = nums[n - 1], mn = nums[0], res = mx - mn;
    for (int i = 0; i < n - 1; ++i) {
      mx = max(mx, nums[i] + 2 * k);
      mn = min(nums[i + 1], nums[0] + 2 * k);
      res = min(res, mx - mn);
    }
    return res;
  }
};
