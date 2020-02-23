#include <string>

using namespace std;

class Solution {
 public:
  string addBinary(string a, string b) {
    if (a.empty() || b.empty()) {
      return a.empty() ? b : a;
    }
    int carry = 0, i = a.size() - 1, j = b.size() - 1;
    string res = "";
    while (i >= 0 || j >= 0 || carry) {
      carry += i >= 0 ? a[i--] - '0' : 0;
      carry += j >= 0 ? b[j--] - '0' : 0;
      res = char(carry % 2 + '0') + res;
      carry /= 2;
    }
    return res;
  }
};
