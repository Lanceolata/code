#include <vector>
#include <numeric>

using namespace std;

class Solution {
 public:
  bool makesquare(vector<int>& matchsticks) {
    if (matchsticks.empty() || matchsticks.size() < 4) {
      return false;
    }
    int sum = accumulate(matchsticks.begin(), matchsticks.end(), 0);
    if (sum % 4 != 0) {
      return false;
    }
    vector<int> sums(4, 0);
    sort(matchsticks.rbegin(), matchsticks.rend());
    return help(matchsticks, sums, 0, sum / 4);
  }

  bool help(vector<int>& nums, vector<int>& sums, int pos, int target) {
    if (pos >= nums.size()) {
      return sums[0] == target && sums[1] == target && sums[2] == target;
    }
    for (int i = 0; i < 4; ++i) {
      if (sums[i] + nums[pos] > target) {
        continue;
      }
      sums[i] += nums[pos];
      if (help(nums, sums, pos + 1, target)) {
        return true;
      }
      sums[i] -= nums[pos];
    }
    return false;
  }
};
