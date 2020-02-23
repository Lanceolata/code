#include <string>

using namespace std;

class Solution {
 public:
  int numDecodings(string s) {
    if (s.empty() || s[0] == '0') {
      return 0;
    }
    int num1 = 1, num2 = 1, num = 1;
    for (int i = 1; i < s.size(); i++) {
      if (s[i] == '0') {
        if (s[i-1] == '1' || s[i-1] == '2') {
          num = num1;
        } else {
          return 0;
        }
      } else {
        if (s[i-1] == '0' || s[i - 1] >= '3') {
          num = num2;
        } else {
          if(s[i-1] == '2' && s[i] >='7' && s[i] <= '9')
            num = num2;
          else
            num = num1 + num2;
        }
      }
      num1 = num2;
      num2 = num;
    }
    return num2;
  }
};
