#include <vector>

using namespace std;

class Solution {
 public:
  void sortColors_elegant(vector<int>& nums) {
    int i = -1, j = -1, k = -1;
    for (int p = 0; p < nums.size(); p++) {
      if (nums[p] == 0) {
        nums[++k] = 2;
        nums[++j] = 1;
        nums[++i] = 0;
      } else if (nums[p] == 1) {
        nums[++k] = 2;
        nums[++j] = 1;
      } else {
        nums[++k] = 2;
      }
    }
  }
};
