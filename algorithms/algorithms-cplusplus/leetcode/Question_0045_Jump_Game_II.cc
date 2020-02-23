#include <vector>

using namespace std;

class Solution {
 public:
  int jump(vector<int>& nums) {
    int res = 0, n = nums.size(), i = 0, cur = 0, pre = 0;
    while (cur < n - 1) {
      ++res;
      pre = cur;
      for (; i <= pre; i++) {
        cur = max(cur, i + nums[i]);
      }
      if (pre == cur) {
        return -1;
      }
    }
    return res;
  }
};
