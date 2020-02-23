#include <string>

using namespace std;

class Solution {
 public:
  string addStrings(string num1, string num2) {
    string res;
    int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
    while (i >= 0 || j >= 0 || carry > 0) {
      carry += i >= 0 ? num1[i--] - '0' : 0;
      carry += j >= 0 ? num2[j--] - '0' : 0;
      res = to_string(carry % 10) + res;
      carry /= 10;
    }
    return res;
  }
};
