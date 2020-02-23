#include <iostream>
#include <vector>

using namespace std;

class Solution {
 public:
  void moveZeroes(vector<int>& nums) {
    size_t i = 0;
    for (size_t j = 0; j < nums.size(); j++) {
      if (nums[j] == 0) {
        continue;
      }
      nums[i++] = nums[j];
    }
    for (; i < nums.size(); i++) {
      nums[i] = 0;
    }
  }
};
