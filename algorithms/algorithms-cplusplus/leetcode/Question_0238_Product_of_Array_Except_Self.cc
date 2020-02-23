#include <vector>

using namespace std;

class Solution {
 public:
  vector<int> productExceptSelf(vector<int>& nums) {
    size_t n = nums.size();
    vector<int> res(n);
    res[0] = 1;
    int p = 1;
    for (int i = 1; i < n; i++) {
      p *= nums[i - 1];
      res[i] = p;
    }
    p = 1;
    for (int i = n - 2; i >= 0; i--) {
      p *= nums[i + 1];
      res[i] *= p;
    }
    return res;
  }
};
