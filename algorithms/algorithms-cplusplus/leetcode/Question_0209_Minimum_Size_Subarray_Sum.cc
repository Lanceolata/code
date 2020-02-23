#include <limits.h>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
 public:
  int minSubArrayLen(int s, vector<int>& nums) {
    int res = INT_MAX, sum = 0;
    for (int i = 0, j = 0; j < nums.size(); j++) {
      sum += nums[j];
      while (sum >= s) {
        res = min(res, j - i + 1);
        sum -= nums[i++];
      }
    }
    return (res == INT_MAX) ? 0 : res;
  }
};
