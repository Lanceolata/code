#include <string>

using namespace std;

class Solution {
 public:
  int calculate(string s) {
    long res = 0, cur = 0, num = 0, n = s.size();
    char op = '+';
    for (int i = 0; i < n; ++i) {
      char c = s[i];
      if (c >= '0' && c <= '9') {
        num = num * 10 + c - '0';
      }
      if (c == '+' || c == '-' || c == '*' || c == '/' || i == n - 1) {
        switch (op) {
          case '+':
            cur += num;
            break;
          case '-':
            cur -= num;
            break;
          case '*':
            cur *= num;
            break;
          case '/':
            cur /= num;
            break;
        }
        if (c == '+' || c == '-' || i == n - 1) {
          res += cur;
          cur = 0;
        }
        op = c;
        num = 0;
      } 
    }
    return (int)res;
  }
};
