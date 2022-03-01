#include <vector>

using namespace std;

class Solution {
 public:
  int pivotIndex(vector<int>& nums) {
    int sum = 0, l = 0;
    for (int n : nums) {
      sum += n;
    }
    for (int i = 0; i < nums.size(); i++) {
      sum -= nums[i];
      if (l == sum) {
        return i;
      }
      l += nums[i];
    }
    return -1;
  }
};
