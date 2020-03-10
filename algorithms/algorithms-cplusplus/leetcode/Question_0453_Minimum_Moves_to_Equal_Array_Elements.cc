#include <vector>
#include <algorithm>

using namespace std;

class Solution {
 public:
  int minMoves(vector<int>& nums) {
    if (nums.size() <= 1) {
      return 0;
    }
    long sum = 0, n = nums[0];
    for (long num : nums) {
      n = min(n, num);
      sum += num;
    }
    return (int)(sum - n * nums.size());
  }
};
