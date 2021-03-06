#include <vector>

using namespace std;

class Solution {
 public:
  int wiggleMaxLength_dp(vector<int>& nums) {
    if (nums.size() < 2) {
      return nums.size();
    }
    vector<int> up(nums.size(), 0), down(nums.size(), 0);
    up[0] = down[0] = 1;
    for (int i = 1; i < nums.size(); i++) {
      if (nums[i] > nums[i - 1]) {
        up[i] = down[i - 1] + 1;
        down[i] = down[i - 1];
      } else if (nums[i] < nums[i - 1]) {
        down[i] = up[i - 1] + 1;
        up[i] = up[i - 1];
      } else {
        down[i] = down[i - 1];
        up[i] = up[i - 1];
      }
    }
    return max(down[nums.size() - 1], up[nums.size() - 1]);
  }

  int wiggleMaxLength_dp(vector<int>& nums) {
    if (nums.size() < 2) {
      return nums.size();
    }
    int down = 1, up = 1;
    for (int i = 1; i < nums.size(); i++) {
      if (nums[i] > nums[i - 1]) {
        up = down + 1;
      } else if (nums[i] < nums[i - 1]) {
        down = up + 1;
      }
    }
    return max(down, up);
  }
};
