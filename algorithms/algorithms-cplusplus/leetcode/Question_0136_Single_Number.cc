#include <vector>

using namespace std;

class Solution {
 public:
  int singleNumber(vector<int>& nums) {
    int res = 0;
    for (size_t i = 0; i < nums.size(); i++) {
      res ^= nums[i];
    }
    return res;
  }
};
