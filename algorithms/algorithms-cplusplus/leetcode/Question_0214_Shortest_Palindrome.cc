#include <string>

using namespace std;

class Solution {
 public:
  string shortestPalindrome(string s) {
    int l = 0;
    for (int r = s.size() - 1; r >= 0; r--) {
      if (s[l] == s[r]) {
        l++;
      }
    }
    if (l == s.size()) {
      return s;
    }
    string suffix = s.substr(l);
    string revs = suffix;
    reverse(revs.begin(), revs.end());
    return revs + shortestPalindrome(s.substr(0, l)) + suffix;
  }
};
