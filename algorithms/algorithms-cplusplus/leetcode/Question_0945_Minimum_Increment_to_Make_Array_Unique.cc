#include <vector>

using namespace std;

class Solution {
 public:
  int minIncrementForUnique(vector<int>& nums) {
    sort(nums.begin(), nums.end());
    int moves = 0, taken = 0;
    for (int i = 1; i < nums.size(); ++i) {
      if (nums[i - 1] == nums[i]) {
        taken++;
        moves -= nums[i];
      } else {
        int give = min(taken, nums[i] - nums[i - 1] - 1);
        moves += give * (give + 1) / 2 + give * nums[i - 1];
        taken -= give;
      }
    }
    if (nums.size() > 0) {
      moves += taken * (taken + 1) / 2 + taken * nums[nums.size() - 1];
    }
    return moves;
  }
};
