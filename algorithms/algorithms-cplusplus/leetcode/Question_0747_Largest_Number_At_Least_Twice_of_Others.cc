#include <vector>

using namespace std;

class Solution {
 public:
  int dominantIndex(vector<int>& nums) {
    int idx = 0;
    for (int i = 1; i < nums.size(); i++) {
      if (nums[i] > nums[idx]) {
        idx = i;
      }
    }
    for (int i = 0; i < nums.size(); i++) {
      if (i == idx) {
        continue;
      }
      if ((double) nums[idx] / nums[i] < 2.0) {
        return -1;
      }
    }
    return idx;
  }
};
