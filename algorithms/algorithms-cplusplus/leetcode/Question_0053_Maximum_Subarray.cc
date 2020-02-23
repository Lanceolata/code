#include <limits.h>
#include <vector>

using namespace std;

class Solution {
 public:
  int maxSubArray(vector<int>& nums) {
    if (nums.size() == 0) {
      return 0;
    }
    int res = INT_MIN, cur = 0;
    for (int i = 0; i < nums.size(); i++) {
      cur += nums[i];
      res = max(res, cur);
      if (cur < 0) {
        cur = 0;
      }
    }
    return res;
  }
};
