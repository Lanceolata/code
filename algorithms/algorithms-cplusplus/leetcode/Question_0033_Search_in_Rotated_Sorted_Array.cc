#include <vector>

using namespace std;

class Solution {
 public:
  int search(vector<int>& nums, int target) {
    int l = 0, r = nums.size() - 1, m = 0;
    while (l <= r) {
      m = l + (r  - l) / 2;
      if (nums[m] == target) {
        return m;
      }
      if (nums[m] >= nums[l]) {
        // 中间数据大于等于最左侧数据
        // 左侧有序
        if (target >= nums[l] && target <= nums[m]) {
          r = m - 1;
        } else {
          l = m + 1;
        }
      } else {
        // 中间数据小于最左侧数据
        // 右侧有序
        if (target >= nums[m] && target <= nums[r]) {
          l = m + 1;
        } else {
          r = m - 1;
        }
      }
    }
    return -1;
  }
};
