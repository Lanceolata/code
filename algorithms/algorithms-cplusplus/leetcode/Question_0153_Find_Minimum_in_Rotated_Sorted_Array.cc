#include <vector>
#include <algorithm>

using namespace std;

class Solution {
 public:
  int findMin(vector<int>& nums) {
    if (nums.empty()) {
      return 0;
    }
    int l = 0, r = nums.size() - 1, m;
    while (l < r) {
      m = l + (r - l) / 2;
      if (nums[m] < nums[r]) {
        r = m;
      } else {
        l = m + 1;
      }
    }
    return nums[l];
  }
};
