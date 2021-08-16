#include <string>
#include <algorithm>

using namespace std;

class Solution {
 public:
  string reverseStr(string s, int k) {
    if (s.empty() || k <= 1) {
      return s;
    }
    for (int i = 0; i < s.size();) {
      int l = i, r = min(i + k - 1, (int)(s.size() - 1));
      while (l < r) {
        swap(s[l++], s[r--]);
      }
      i += 2 * k;
    }
    return s;
  }
};
