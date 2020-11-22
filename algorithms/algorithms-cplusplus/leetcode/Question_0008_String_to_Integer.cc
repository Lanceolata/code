#include <limits.h>
#include <string>

using namespace std;

class Solution {
 public:
  int myAtoi(string s) {
    if (s.empty()) {
      return 0;
    }
    int i = 0, n = s.size(), sign = 1, res = 0;
    while (i < n && s[i] == ' ') {
      i++;
    }
    if (i < n && (s[i] == '-' || s[i] == '+')) {
      sign = (s[i++] == '-') ? -1 : 1;
    }
    while (i < n && s[i] >= '0' && s[i] <= '9') {
      if (res > INT_MAX / 10 || (res == INT_MAX / 10 && s[i] - '0' > 7)) {
        return (sign == 1) ? INT_MAX : INT_MIN;
      }
      res = res * 10 + (s[i++] - '0');
    }
    return sign * res;
  }
};
