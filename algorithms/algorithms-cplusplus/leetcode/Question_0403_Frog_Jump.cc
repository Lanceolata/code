#include <vector>
#include <unordered_map>
#include <unordered_set>

using namespace std;

class Solution {
 public:
  bool canCross(vector<int>& stones) {
    // 石头和在该位置上能跳的距离
    unordered_map<int, unordered_set<int>> m;
    // dp[i] 表示在位置为i的石头青蛙的弹跳力
    vector<int> dp(stones.size(), 0);
    m[0].insert(0);
    int k = 0;
    for (int i = 1; i < stones.size(); i++) {
      
    }
    for (int i = 1; i < stones.size(); ++i) {
      while (dp[k] + 1 < stones[i] - stones[k]) {
        ++k;
      }
      for (int j = k; j < i; ++j) {
        int t = stones[i] - stones[j];
        if (m[j].count(t - 1) || m[j].count(t) || m[j].count(t + 1)) {
          m[i].insert(t);
          dp[i] = max(dp[i], t);
        }
      }
    }
    return dp.back() > 0;
  }
};
