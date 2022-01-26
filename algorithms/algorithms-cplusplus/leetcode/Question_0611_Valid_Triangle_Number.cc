#include <vector>
#include <algorithm>

using namespace std;

class Solution {
 public:
  int triangleNumber(vector<int>& nums) {
    int res = 0;
    sort(nums.begin(), nums.end());
    for (int k = nums.size() - 1; k >= 2; k--) {
      int i = 0, j = k - 1;
      while (i < j) {
        if (nums[i] + nums[j] > nums[k]) {
          res += j - i;
          j--;
        } else {
          i++;
        }
      }
    }
    return res;
  }
};
