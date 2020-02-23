#include <math.h>
#include <vector>

using namespace std;

class Solution {
 public:
  int maxProductAfterCutting(int length) {
    if (length < 2) {
      return 0;
    }
    if (length <= 3) {
      return length - 1;
    }
    vector<int> dp(length + 1, 0);
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 3;

    int tmp = 0;
    for(int i = 4; i <= length; i++) {
      for (int j = 1; j <= i / 2; j++) {
        tmp = dp[j] * dp[i - j];
        dp[i] = max(dp[i], tmp);
      }
    }
    return dp[length];
  }
};
