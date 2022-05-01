#include <vector>

using namespace std;

class Solution {
 public:
  int numSubarraysWithSum(vector<int>& nums, int goal) {
    int iLo = 0, iHi = 0, sumLo = 0, sumHi = 0, res = 0;
    for (int j = 0; j < nums.size(); ++j) {
      sumLo += nums[j];
      while (iLo < j && sumLo > goal) {
        sumLo -= nums[iLo++];
      }
      sumHi += nums[j];
      while (iHi < j && (sumHi > goal || sumHi == goal && nums[iHi] == 0)) {
        sumHi -= nums[iHi++];
      }
      if (sumLo == goal) {
        res += iHi - iLo + 1;
      }
    }
    return res;
  }
};
