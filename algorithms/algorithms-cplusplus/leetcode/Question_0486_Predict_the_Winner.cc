#include <vector>

using namespace std;

class Solution {
 public:
  bool PredictTheWinner(vector<int>& nums) {
    int n = nums.size();
    vector<vector<int>> dp(n, vector<int>(n, -1));
    return canWin(nums, 0, n - 1, dp) >= 0;
  }

  int canWin(vector<int>& nums, int s, int e, vector<vector<int>>& dp) {
    if (dp[s][e] == -1) {
      dp[s][e] = (s == e) ? nums[s] : max(nums[s] - canWin(nums, s + 1, e, dp), nums[e] - canWin(nums, s, e - 1, dp));
    }
    return dp[s][e];
  }

  bool PredictTheWinner2(vector<int>& nums) {
    int n = nums.size();
    vector<vector<int>> dp(n, vector<int>(n, 0));
    for (int i = 0; i < n; ++i) {
      dp[i][i] = nums[i];
    }
    for (int len = 1; len < n; ++len) {
      for (int i = 0, j = len; j < n; ++i, ++j) {
        dp[i][j] = max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
      }
    }
    return dp[0][n - 1] >= 0;
  }
};
