#include <vector>
#include <unordered_set>

using namespace std;

class Solution {
 public:
    int orderOfLargestPlusSign(int n, vector<vector<int>>& mines) {
        unordered_set<int> banned;
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (vector<int>& mine : mines) {
          banned.insert(mine[0] * n + mine[1]);
        }
        int res = 0, count;
        for (int r = 0; r < n; r++) {
            // left
            count = 0;
            for (int c = 0; c < n; c++) {
                count = banned.count(r * n + c) ? 0 : count + 1;
                dp[r][c] = count;
            }
            // right
            count = 0;
            for (int c = n - 1; c >= 0; c--) {
                count = banned.count(r * n + c) ? 0 : count + 1;
                dp[r][c] = min(dp[r][c], count);
            }
        }
        for (int c = 0; c < n; c++) {
            // up
            count = 0;
            for (int r = 0; r < n; r++) {
                count = banned.count(r * n + c) ? 0 : count + 1;
                dp[r][c] = min(dp[r][c], count);
            }
            // down
            count = 0;
            for (int r = n - 1; r >= 0; --r) {
                count = banned.count(r * n + c) ? 0 : count + 1;
                dp[r][c] = min(dp[r][c], count);
                res = max(res, dp[r][c]);
            }
        }
        return res;
    }
};
