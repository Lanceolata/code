#include <vector>

using namespace std;

class Solution {
 public:
  int lengthOfLIS(vector<int>& nums) {
    if (nums.empty()) {
      return 0;
    }
    int n = nums.size(), res = 0, cur = 0;
    // dp[i]表示0-i最长递增序列长度
    vector<int> dp(nums.size(), 0);
    for (int i = 0; i < dp.size(); i++) {
      cur = 0;
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          cur = max(cur, dp[j]);
        }
      }
      dp[i] = cur + 1;
      res = max(res, dp[i]);
    }
    return res;
  }

  int lengthOfLISOpt(vector<int>& nums) {
    if (nums.empty()) {
      return 0;
    }
    vector<int> dp;
    int l, r, m;
    for (int i = 0; i < nums.size(); i++) {
      l = 0; r = dp.size();
      // 找到第一个大于nums[i]的数
      // 这个缓存数组是递增的但它并不是输入数组的LIS。
      // 因为它在不停尝试着构造可能是LIS的东西。
      // 这是一个虽然不是LIS但是能够构造LIS长度的一个东西。
      while (l < r) {
        m = l + (r - l) / 2;
        if (dp[m] < nums[i]) {
          l = m + 1;
        } else {
          r = m;
        }
      }
      if (r >= dp.size()) {
        dp.push_back(nums[i]);
      } else {
        dp[r] = nums[i];
      }
    }
    return dp.size();
  }
};
