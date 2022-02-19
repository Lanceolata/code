#include <string>

using namespace std;

class Solution {
 public:
  bool checkValidString(string s) {
    int l = 0, h = 0;
    for (char c : s) {
      l += c == '(' ? 1 : -1;
      h += c != ')' ? 1 : -1;
      if (h < 0) {
        break;
      }
      l = max(l, 0);
    }
    return l == 0;
  }
};
