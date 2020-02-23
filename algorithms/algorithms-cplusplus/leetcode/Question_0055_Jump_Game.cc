#include <vector>

using namespace std;

class Solution {
 public:
  bool canJump(vector<int>& nums) {
    if (nums.empty()) {
      return false;
    }
    int m = 0;
    for (int i = 0; i < nums.size(); i++) {
      m = max(m, i + nums[i]);
      if (m < i + 1) {
        return false;
      }
      if (m >= nums.size() - 1) {
        return true;
      }
    }
    return false;
  }
};
