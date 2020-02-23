#include <vector>

using namespace std;

class Solution {
 public:
  int GetNumberSameAsIndex(vector<int>& nums) {
    if (nums.empty()) {
      return -1;
    }
    int l = 0, r = nums.size() - 1, m;
    while (l <= r) {
      m = l + (r - l) / 2;
      if (nums[m] == m) {
        return m;
      } else if (nums[m] > m) {
        r = m - 1;
      } else {
        l = m + 1;
      }
    }
    return -1;
  }
};
