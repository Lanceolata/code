#include <vector>
#include <algorithm>

using namespace std;

class Solution {
 public:
  int maxProduct(vector<int>& nums) {
    if (nums.empty()) {
      return 0;
    }
    int pre_min = nums[0], pre_max = nums[0], res = nums[0];
    int cur_min, cur_max;
    for (int i = 1; i < nums.size(); i++) {
      int n = nums[i];
      cur_min = min(n, min(pre_min * n, pre_max * n));
      cur_max = max(n, max(pre_min * n, pre_max * n));
      pre_min = cur_min;
      pre_max = cur_max;
      res = max(res, cur_max);
    }
    return res;
  }
};
