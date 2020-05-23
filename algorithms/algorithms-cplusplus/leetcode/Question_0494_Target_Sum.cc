#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
 public:
  int findTargetSumWays(vector<int>& nums, int S) {
    int res = 0;
    help(nums, S, 0, res);
    return res;
  }

  void help(vector<int>& nums, long S, int i, int& res) {
    if (i >= nums.size()) {
      if (S == 0) {
        ++res;
      }
      return;
    }
    help(nums, S - nums[i], i + 1, res);
    help(nums, S + nums[i], i + 1, res);
  }

  int findTargetSumWays2(vector<int>& nums, int S) {
    unordered_map<int, int> dp;
    dp[0] = 1;
    for (int num : nums) {
      unordered_map<int, int> t;
      for (auto a : dp) {
        int sum = a.first, cnt = a.second;
        t[sum + num] += cnt;
        t[sum - num] += cnt;
      }
      dp = t;
    }
    return dp[S];
  }
};
