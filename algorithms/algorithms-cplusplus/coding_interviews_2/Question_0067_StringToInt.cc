#include <limits.h>
#include <string>

using namespace std;

class Solution {
 public:
  int StrToInt(string str) {
    if (str.empty()) {
      return 0;
    }
    int i = 0, sign = 1;
    if (str[i] == '+' || str[i] == '-') {
      if (str[i] == '-') {
        sign = -1;
      }
      i++;
    }
    int res = 0;
    while (i < str.size()) {
      if (str[i] < '0' || str[i] > '9') {
        return 0;
      }
      int tmp = str[i++] - '0';
      if (res > INT_MAX / 10 || (res == INT_MAX / 10 && tmp > 7)) {
        if (sign == 1 || tmp > 8) {
          return 0;
        }
      }
      res = res * 10 + tmp;
    }
    return sign * res;
  }
};
