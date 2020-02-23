#include <vector>
#include <numeric>
#include <bitset>

using namespace std;

class Solution {
 public:
  bool canPartition_dp(vector<int>& nums) {
    int sum = accumulate(nums.begin(), nums.end(), 0), target = sum >> 1;
    if (sum & 1) {
      return false;
    }
    vector<bool> dp(target + 1, false);
    dp[0] = true;
    for (int num : nums) {
      for (int i = target; i >= num; --i) {
        dp[i] = dp[i] || dp[i - num];
      }
    }
    return dp[target];
  }

  bool canPartition(vector<int>& nums) {
    bitset<5001> bits(1);
    int sum = accumulate(nums.begin(), nums.end(), 0);
    for (int num : nums) bits |= bits << num;
    return (sum % 2 == 0) && bits[sum >> 1];
  }
};
