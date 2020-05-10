#include <vector>

using namespace std;

class Solution {
 public:
  int findMaxConsecutiveOnes(vector<int>& nums) {
    int res = 0, cnt = 0;
    for (int n : nums) {
      if (n == 1) {
        cnt++;
        res = max(res, cnt);
      } else {
        cnt = 0;
      }
    }
    return res;
  }
};
