#include <vector>
#include <bitset>

using namespace std;

class Solution {
 public:
  int lastStoneWeightII(vector<int>& stones) {
    bitset<1501> dp = {1};
    int sum = 0;
    for (int s : stones) {
      sum += s;
      for (int i = min(1500, sum); i >= s; --i) {
        dp[i] = dp[i] + dp[i - s];
      }
    }
    for (int i = sum / 2; i >= 0; --i) {
      if (dp[i]) {
        return sum - i - i;
      }
    }
    return 0;
  }
};
