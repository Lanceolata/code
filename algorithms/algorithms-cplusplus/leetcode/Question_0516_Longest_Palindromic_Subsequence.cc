#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  int longestPalindromeSubseq(string s) {
    int n = s.size(), res = 0;
    vector<int> dp(n, 1);
    for (int i = n - 1; i >= 0; --i) {
      int len = 0;
      for (int j = i + 1; j < n; ++j) {
        int t = dp[j];
        if (s[i] == s[j]) {
          dp[j] = len + 2;
        } 
        len = max(len, t);
      }
    }
    for (int num : dp) {
      res = max(res, num);
    }
    return res;
  }
};
