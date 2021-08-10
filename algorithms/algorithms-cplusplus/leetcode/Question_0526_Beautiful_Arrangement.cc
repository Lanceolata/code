#include <vector>

using namespace std;

class Solution {
 public:
  int countArrangement(int n) {
    vector<int> nums(n);
    for (int i = 0; i < n; ++i) {
      nums[i] = i + 1;
    }
    return help(n, nums);
  }

  int help(int n, vector<int> nums) {
    if (n <= 0) {
      return 1;
    }
    int res = 0;
    for (int i = 0; i < n; ++i) {
      if (n % nums[i] == 0 || nums[i] % n == 0) {
        swap(nums[i], nums[n - 1]);
        res += help(n - 1, nums);
        swap(nums[i], nums[n - 1]);
      }
    }
    return res;
  }
};
