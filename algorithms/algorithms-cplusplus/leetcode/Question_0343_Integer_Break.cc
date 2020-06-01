#include <math.h>
#include <vector>

using namespace std;

class Solution {
 public:
  int integerBreak1(int n) {
    if (n == 2 || n == 3) {
      return n - 1;
    }
    int res = 1;
    while(n > 4) {
      res *= 3;
      n -= 3;
    }
    return res * n;
  }

  int integerBreak2(int n) {
    vector<int> dp(n + 1, 0);
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      for (int j = 1; j < i; j++) {
        dp[i] = max(dp[i], (max(j, dp[j])) * (max(i - j, dp[i - j])));
      }
    }
    return dp[n];
  }

  int integerBreak3(int n) {
    if (n == 2 || n == 3) {
      return n - 1;
    }
    if (n == 4) {
      return 4;
    }
    n -= 5;
    return (int)pow(3, (n / 3 + 1)) * (n % 3 + 2);
  }
};
