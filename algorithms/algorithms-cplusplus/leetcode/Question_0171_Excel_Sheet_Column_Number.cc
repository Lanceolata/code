#include <string>

using namespace std;

class Solution {
 public:
  int titleToNumber(string s) {
    int res = 0;
    for (size_t i = 0; i < s.size(); i++) {
      res = res * 26 + (s[i] - 'A' + 1);
    }
    return res;
  }
};
