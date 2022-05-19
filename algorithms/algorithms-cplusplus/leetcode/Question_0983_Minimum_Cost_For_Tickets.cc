#include <vector>
#include <unordered_set>

using namespace std;

class Solution {
 public:
  int mincostTickets(vector<int>& days, vector<int>& costs) {
    unordered_set<int> travel(days.begin(), days.end());
    vector<int> dp(30, 0);
    for (int d = days.front(); d <= days.back(); d++) {
      if (!travel.count(d)) {
        dp[d % 30] = dp[(d - 1) % 30];
      } else {
        dp[d % 30] = min({dp[(d - 1) % 30] + costs[0], dp[max(0, d - 7) % 30] + costs[1], dp[max(0, d - 30) % 30] + costs[2]});
      }
    }
    return dp[days.back() % 30];
  }
};
