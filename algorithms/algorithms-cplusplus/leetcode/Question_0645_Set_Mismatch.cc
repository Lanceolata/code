#include <vector>

using namespace std;

class Solution {
 public:
  vector<int> findErrorNums(vector<int>& nums) {
    int dup = 0, miss = 0;
    for (int n : nums) {
      int index = abs(n) - 1;
      if (nums[index] < 0) {
        dup = abs(n);
      } else {
        nums[index] *= -1;
      }
    }
    for (int i = 0; i < nums.size(); i++) {
      if (nums[i] > 0) {
        miss = i + 1;
      }
    }
    return {dup, miss};
  }
};
