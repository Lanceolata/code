#include <vector>

using namespace std;

class Solution {
 public:
  int removeDuplicates(vector<int>& nums) {
    if (nums.empty()) {
      return 0;
    }
    size_t index = 0;
    int count = 0;
    for (size_t i = 0; i < nums.size(); i++) {
      if (i > 0 && nums[i - 1] == nums[i]) {
        count++;
        if (count >= 2) {
          continue;
        }
      } else {
        count = 0;
      }
      nums[index++] = nums[i];
    }
    return index;
  }
};
