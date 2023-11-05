#include <string>

using namespace std;

class Solution {
 public:
  string gcdOfStrings(string str1, string str2) {
    if (str1 + str2 != str2 + str1) {
      return "";
    }
    int gcdLength = gcd(str1.size(), str2.size());
    return str1.substr(0, gcdLength);
  }

  int gcd(int x, int y) {
    if (y == 0) {
      return x;
    } else {
      return gcd(y, x % y);
    }
  }
};
