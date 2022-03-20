#include <vector>

using namespace std;

class Solution {
 public:
  double largestSumOfAverages(vector<int>& nums, int k) {
    int n = nums.size();
    vector<double> p(n + 1);
    for (int i = 0; i < n; ++i) {
      p[i + 1] = p[i] + nums[i];
    }
    vector<double> dp(n);
    for (int i = 0; i < n; ++i) {
      dp[i] = (p[n] - p[i]) / (n - i);
    }
    for (int z = 0; z < k - 1; ++z) {
      for (int i = 0; i < n; ++i) {
        for (int j = i + 1; j < n; ++j) {
          dp[i] = max(dp[i], (p[j] - p[i]) / (j - i) + dp[j]);
        }
      }
    }
    return dp[0];
  }
};
