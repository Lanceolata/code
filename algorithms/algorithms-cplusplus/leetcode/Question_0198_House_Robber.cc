#include <vector>

using namespace std;

class Solution {
 public:
  int rob(vector<int>& nums) {
    int prerob = 0, prenotrob = 0;
    for (size_t i = 0; i < nums.size(); i++) {
      int temp = prerob;
      prerob = prenotrob + nums[i];
      prenotrob = max(temp, prenotrob);
    }
    return max(prerob, prenotrob);
  }
};
