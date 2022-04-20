#include <vector>

using namespace std;

class Solution {
 public:
  bool isMonotonic(vector<int>& nums) {
    if (nums.size() <= 1) {
      return true;
    }
    int flag = 0;
    for (int i = 1; i < nums.size(); i++) {
      if (nums[i] == nums[i - 1]) {
        continue;
      }
      int t = nums[i] > nums[i - 1] ? 1 : -1;
      if (flag != 0 && flag != t) {
        return false;
      }
      flag = t;
    }
    return true;
  }
};
