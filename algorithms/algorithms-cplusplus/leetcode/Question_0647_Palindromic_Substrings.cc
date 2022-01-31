#include <string>

using namespace std;

class Solution {
 public:
  int countSubstrings(string s) {
    int res = 0;
    for (int i = 0; i < s.size(); i++) {
      res += help(s, i, i);
      res += help(s, i, i + 1);
    }
    return res;
  }

  int help(string s, int l, int r) {
    int res = 0;
    while (l >= 0 && r < s.size() && s[l] == s[r]) {
      res++;
      l--;
      r++;
    }
    return res;
  }
};
