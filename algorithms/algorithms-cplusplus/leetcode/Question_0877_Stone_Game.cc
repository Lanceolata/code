#include <vector>

using namespace std;

class Solution {
 public:
  bool stoneGame(vector<int>& piles) {
    int n = piles.size();
    vector<vector<int>> dp(n, vector<int>(n, 0));
    for (int d = 1; d < n; d++) {
      for (int i = 0; i < n - d; i++) {
        dp[i][i + d] = max(piles[i] - dp[i + 1][i + d], piles[i + d] - dp[i][i + d - 1]);
      }
    }
    return dp[0][n - 1] > 0;
  }

  bool stoneGame_math(vector<int>& piles) {
    return true;
  }
};
