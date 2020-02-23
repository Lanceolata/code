#include <string>

using namespace std;

class Solution {
 public:
  string longestPalindrome(string s) {
    int start = 0, len = 0;
    for (int i = 0; i < s.size(); i++) {
      expandAroundCenter(s, i, i, start, len);
      expandAroundCenter(s, i, i + 1, start, len);
    }
    return s.substr(start, len);
  }

  void expandAroundCenter(string& s, int l, int r, int& start, int& len) {
    while (l >= 0 && r < s.size() && s[l] == s[r]) {
      l--; r++;
    }
    if (r - l - 1 > len) {
      len = r - l - 1;
      start = l + 1;
    }
  }
};
