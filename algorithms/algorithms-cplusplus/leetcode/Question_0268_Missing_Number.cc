#include <vector>

using namespace std;

class Solution {
 public:
  int missingNumber(vector<int>& nums) {
    int len = nums.size();
    int sum = (0 + len) * (len + 1)/2;
    for (size_t i = 0; i < nums.size(); i++) {
      sum -= nums[i];
    }
    return sum;
  }

  int missingNumber2(vector<int>& nums) {
    int res = nums.size();
    for (size_t i = 0; i < nums.size(); i++) {
      res ^= i;
      res ^= nums[i];
    }
    return res;
  }
};
