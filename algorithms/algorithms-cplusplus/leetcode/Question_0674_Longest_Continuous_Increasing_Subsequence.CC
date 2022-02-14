#include <vector>

using namespace std;

class Solution {
 public:
  int findLengthOfLCIS(vector<int>& nums) {
    int n = nums.size(), res = 1, cur = 1;
    for (int i = 1; i <= n; i++) {
      if (i == n || nums[i] <= nums[i - 1]) {
        res = max(res, cur);
        cur = 1;
      } else {
        cur++;
      }
    }
    return res;
  }
};
