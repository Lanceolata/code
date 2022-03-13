#include <vector>

using namespace std;

class Solution {
 public:
  int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
    vector<int> dp(n, 1e9);
    dp[src] = 0;
    for (int i = 0; i <= k; ++i) {
      vector<int> t = dp;
      for (auto x : flights) {
        t[x[1]] = min(t[x[1]], dp[x[0]] + x[2]);
      }
      dp = t;
    }
    return (dp[dst] >= 1e9) ? -1 : dp[dst];
  }
};
