#include <vector>
#include <algorithm>

using namespace std;

class Solution {
 public:
  int rob(vector<int>& nums) {
    if (nums.empty()) {
      return 0;
    }
    if (nums.size() == 1) {
      return nums[0];
    }
    return max(rob(nums, 0, nums.size() - 2), rob(nums, 1, nums.size() - 1));
  }

  int rob(vector<int>& nums, size_t start, size_t end) {
    int prerob = 0, prenotrob = 0;
    for (size_t i = start; i <= end; i++) {
      int temp = prerob;
      prerob = prenotrob + nums[i];
      prenotrob = max(temp, prenotrob);
    }
    return max(prerob, prenotrob);
  }
};
