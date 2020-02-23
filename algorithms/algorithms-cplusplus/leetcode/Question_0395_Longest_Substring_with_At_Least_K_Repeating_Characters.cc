#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  int longestSubstringSimple(string s, int k) {
    int res = 0, i = 0, n = s.size();
    while (i + k <= n) {
      int m[26] = {0}, mask = 0, max_idx = i;
      for (int j = i; j < n; ++j) {
        int t = s[j] - 'a';
        ++m[t];
        if (m[t] < k) {
          mask |= (1 << t);
        } else {
            mask &= (~(1 << t));
        }
        if (mask == 0) {
          res = max(res, j - i + 1);
          max_idx = j;
        }
      }
      i = max_idx + 1;
    }
    return res;
  }

  int longestSubstring(string s, int k) {
    int n = s.size(), max_idx = 0, res = 0;
    vector<int> index(128, 0);
    bool flag = true;
    for (char c : s) {
      ++index[c];
    }
    for (int i = 0; i < n; ++i) {
      if (index[s[i]] < k) {
        res = max(res, longestSubstring(s.substr(max_idx, i - max_idx), k));
        flag = false;
        max_idx = i + 1;
      }
    }
    return flag ? n : max(res, longestSubstring(s.substr(max_idx, n - max_idx), k));
  }
};
