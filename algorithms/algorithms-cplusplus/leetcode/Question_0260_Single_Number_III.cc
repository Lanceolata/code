#include <vector>

using namespace std;

class Solution {
 public:
  vector<int> singleNumber(vector<int>& nums) {
    int diff = 0;
    for (int n : nums) {
      diff ^= n;
    }

    diff = diff & (~(diff - 1));
    vector<int> res(2, 0);
    for (int n : nums) {
      if ((n & diff) == 0) {
        res[0] ^= n;
      } else {
        res[1] ^= n;
      }
    }
    return res;
  }
};
