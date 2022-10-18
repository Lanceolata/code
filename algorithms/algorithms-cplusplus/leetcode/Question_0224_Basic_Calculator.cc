#include <string>
#include <stack>

using namespace std;

class Solution {
 public:
  int calculate(string s) {
    stack<int> st;
    int res = 0, num = 0, sign = 1;
    for (char c : s) {
      if (c >= '0' && c <= '9') {
        num = 10 * num + (c - '0');
      } else if (c == '+') {
        res += sign * num;
        num = 0;
        sign = 1;
      } else if (c == '-') {
        res += sign * num;
        num = 0;
        sign = -1;
      } else if (c == '(') {
        st.push(res);
        st.push(sign);
        sign = 1;
        res = 0;
      } else if (c == ')') {
        res += sign * num;
        num = 0;
        res *= st.top();
        st.pop();
        res += st.top();
        st.pop();
      }
    }
    if (num != 0) {
      res += sign * num;
    }
    return res;
  }
};
