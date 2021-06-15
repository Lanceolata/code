#include <vector>

using namespace std;

class Solution {
 public:
  int maxRotateFunction(vector<int>& nums) {
    long sum = 0, F = 0;
    int n = nums.size();
    for (int i = 0; i < n; i++) {
      F += i * nums[i];
      sum += nums[i];
    }
    long res = F;
    for (int i = n - 1; i >= 1; i--) {
      F = F + sum - (long)(n) * nums[i];
      res = max(res, F);
    }
    return (int)res;
  }
};
