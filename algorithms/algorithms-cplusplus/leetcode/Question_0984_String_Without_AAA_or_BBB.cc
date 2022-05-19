#include <string>

using namespace std;

class Solution {
 public:
  string strWithout3a3b(int a, int b) {
    string res;
    while (a > 0 || b > 0) {
      bool flag = false;
      int l = res.size();
      if (l >= 2 && res[l - 1] == res[l - 2]) {
        if (res[l - 1] == 'b') {
          flag = true;
        }
      } else {
        if (a >= b) {
          flag = true;
        }
      }
      if (flag) {
        a--;
        res.append("a");
      } else {
        b--;
        res.append("b");
      }
    }
    return res;
  }
};
