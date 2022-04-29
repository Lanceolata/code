#include <string>

using namespace std;

class Solution {
 public:
  int minAddToMakeValid(string s) {
    int l = 0, r = 0;
    for (char c : s) {
      if (c == '(') {
        r++;
      } else if (r > 0) {
        r--;
      } else {
        l++;
      }
    }
    return l + r;
  }
};
