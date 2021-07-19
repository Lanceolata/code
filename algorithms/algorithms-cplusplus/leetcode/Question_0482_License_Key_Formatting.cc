#include <string>

using namespace std;

class Solution {
 public:
  string licenseKeyFormatting(string s, int k) {
    string res = "";
    int cnt = 0;
    for (int i = s.size() - 1 ; i >= 0; i--) {
      char c = s[i];
      if (c == '-') {
        continue;
      }
      if (c >= 'a' && c <= 'z') {
        c -= 32;
      }
      res.push_back(c);
      if (++cnt % k == 0) {
        res.push_back('-');
      }
    }

    if (!res.empty() && res.back() == '-') {
      res.pop_back();
    }
    return string(res.rbegin(), res.rend());
  }
};
