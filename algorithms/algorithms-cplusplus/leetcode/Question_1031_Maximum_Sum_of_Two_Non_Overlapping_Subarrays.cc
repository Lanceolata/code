#include <vector>

using namespace std;

class Solution {
 public:
  int maxSumTwoNoOverlap(vector<int>& nums, int firstLen, int secondLen) {
    vector<int> prefixSum(nums.size() + 1);
    for (int i = 0; i < nums.size(); ++i) {
      prefixSum[i + 1] = prefixSum[i] + nums[i];
    }
    return max(maxSum(prefixSum, firstLen, secondLen), maxSum(prefixSum, secondLen, firstLen));
  }

  int maxSum(vector<int>& p, int l, int m) {
    int ans = 0;
    for (int i = l + m, maxL = 0; i < p.size(); ++i) {
      maxL = max(maxL, p[i - m] - p[i - m - l]);
      ans = max(ans, maxL + p[i] - p[i - m]);
    }
    return ans;
  }
};
