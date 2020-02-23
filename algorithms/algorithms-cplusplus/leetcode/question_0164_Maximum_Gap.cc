#include <vector>

using namespace std;

class Solution {
 public:
  int maximumGap(vector<int>& nums) {
    if (nums.size() < 2) {
      return 0;
    }
    sort(nums.begin(), nums.end());
    int res = 0;
    for (int i = 0; i < nums.size() - 1; i++) {
      res = max(res, nums[i + 1] - nums[i]);
    }
    return res;
  }
};
