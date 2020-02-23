#include <string.h>
#include <string>
#include <iostream>

using namespace std;

class Solution {
 public:
  void Print1ToMaxOfNDigits(int n) {
    if (n <= 0) {
      return;
    }
    string s(n, '0');
    help(n, 0, s);
  }

  void help(int n, int i, string& s) {
    if (i >= n) {
      std::cout << s << std::endl;
      return;
    }
    for (char j = '0'; j <= '9'; j++) {
      s[i] = j;
      help(n, i + 1, s);
    }
  }
};
