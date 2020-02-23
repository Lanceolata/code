#include <string>
#include <vector>
#include <unordered_set>

using namespace std;

class Solution {
 public:
  bool wordBreak(string s, vector<string>& wordDict) {
    unordered_set<string> dict(wordDict.begin(), wordDict.end());
    size_t n = s.size();
    vector<bool> dp(n + 1, false);
    dp[0] = true;
    for (size_t pos = 0; pos < n; pos++) {
      for (size_t i = pos; dp[pos] && i < n; i++) {
        if (dict.count(s.substr(pos, i - pos + 1)))
          dp[i + 1] = true;
      }
    }
    return dp[n];
  }
};
