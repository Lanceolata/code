#include <vector>

using namespace std;

class Solution {
 public:
  int integerBreak_math(int n) {
    if(n==2) {
      return 1;
    }
    if(n==3) {
      return 2;
    }
    int product = 1;
    while(n > 4) {
      product *= 3;
      n -= 3;
    }
    product *= n;
    return product;
  }

  int integerBreak(int n) {
    vector<int> dp(n + 1, 0);
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      for (int j = 1; j < i; j++) {
        dp[i] = max(dp[i], (max(j, dp[j])) * (max(i - j, dp[i - j])));
      }
    }
    return dp[n];
  }
};
