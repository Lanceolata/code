#include <vector>

using namespace std;

class Solution {
 public:
  int largestSumAfterKNegations(vector<int>& nums, int k) {
    int j = 0, sum = 0;
    sort(nums.begin(), nums.end());
    for (int i = 0; i < k; i++) {
      if (nums[j] < 0) {
        nums[j] *= -1;
        if (j < nums.size() - 1 && nums[j + 1] < abs(nums[j])) {
          j++;
        }
      } else if (nums[j] >= 0) {
        nums[j] *= -1;
      }
    }
    for (int n : nums) {
      sum += n;
    }
    return sum;
  }
};
