#include <limits.h>
#include <string>

using namespace std;

class Solution {
 public:
  int myAtoi(string str) {
    if (str.empty()) {
      return 0;
    }
    int i = 0, n = str.size(), sign = 1, res = 0;
    while (i < n && str[i] == ' ') {
      i++;
    }
    if (i < n && (str[i] == '-' || str[i] == '+')) {
      sign = (str[i++] == '-') ? -1 : 1;
    }
    while (i < n && str[i] >= '0' && str[i] <= '9') {
      if (res > INT_MAX / 10 || (res == INT_MAX / 10 && str[i] - '0' > 7)) {
        return (sign == 1) ? INT_MAX : INT_MIN;
      }
      res = res * 10 + (str[i++] - '0');
    }
    return sign * res;
  }
};
