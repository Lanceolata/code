#include <string>
#include <algorithm>

using namespace std;

class Solution {
 public:
  int countBinarySubstrings(string s) {
    int res = 0, pre = 0, cur = 1;
    for (int i = 1; i < s.size(); i++) {
      if (s[i - 1] != s[i]) {
        res += min(pre, cur);
        pre = cur;
        cur = 1;
      } else {
        cur++;
      }
    }
    return res + min(pre, cur);
  }
};
