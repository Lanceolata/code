#include <string>

using namespace std;

class Solution {
 public:
  string toHex(int num) {
    if (!num) {
      return "0";
    }
    string res = "";
    int count = 0;
    while (num && count++ < 8) {
      res = m[(num & 0xf)] + res;
      num >>= 4;
    }
    return res;
  }

 private:
  static const char m[];
};

const char Solution::m[] = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
