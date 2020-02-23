#include <vector>
#include <algorithm>

using namespace std;

class Solution {
 public:
  int threeSumClosest(vector<int>& nums, int target) {
    int res = nums[0] + nums[1] + nums[2];
    int diff = abs(res - target);
    sort(nums.begin(), nums.end());
    for (size_t k = 0; k < nums.size(); ++k) {
      size_t l = k + 1, r = nums.size() - 1;
      while (l < r) {
        int sum = nums[k] + nums[l] + nums[r];
        int ndiff = abs(sum - target);
        if (ndiff < diff) {
          diff = ndiff;
          res = sum;
        }
        if (sum < target) {
          ++l;
        } else {
          --r;
        }
      }
    }
    return res;
  }
};
