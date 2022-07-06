#include <limits.h>
#include <vector>

using namespace std;

class Solution {
 public:
  int nthSuperUglyNumber(int n, vector<int>& primes) {
    vector<long long> dp(n, INT_MAX);
    dp[0] = 1;
    vector<int> index(primes.size(), 0);
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < index.size(); j++) {
        dp[i] = min(dp[i], primes[j] * dp[index[j]]);
      }
      for (int j = 0; j < index.size(); j++) {
        if (dp[i] == primes[j] * dp[index[j]]) {
          index[j]++;
        }
      }
    }
    return (int)dp[n - 1];
  }
};
