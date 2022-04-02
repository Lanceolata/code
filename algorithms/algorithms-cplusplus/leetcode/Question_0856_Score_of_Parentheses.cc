#include <string>

using namespace std;

class Solution {
 public:
  int scoreOfParentheses(string s) {
    int res = 0, bal = 0;
    for (int i = 0; i < s.size(); ++i) {
      if (s[i] == '(') {
        bal++;
      } else {
        bal--;
        if (s[i - 1] == '(') {
          res += 1 << bal;
        }
      }
    }
    return res;
  }
};
