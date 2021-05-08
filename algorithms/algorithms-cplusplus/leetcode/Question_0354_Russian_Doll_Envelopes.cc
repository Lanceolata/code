#include <vector>

using namespace std;

class Solution {
 public:
  int maxEnvelopes(vector<vector<int>>& envelopes) {
    int res = 0;
    vector<int> dp(envelopes.size(), 1);
    sort(envelopes.begin(), envelopes.end());
    for (int i = 0; i < envelopes.size(); i++) {
      for (int j = 0; j < i; j++) {
        if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
          dp[i] = max(dp[i], dp[j] + 1);
        }
      }
      res = max(res, dp[i]);
    }
    return res;
  }
};
