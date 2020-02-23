#include <string>
#include <stack>

using namespace std;

class Solution {
 public:
  int longestValidParentheses(string s) {
    int l = 0, r = 0, res = 0;
    for (int i = 0; i < s.size(); i++) {
      if (s[i] == '(') {
        l++;
      } else {
        r++;
      }
      if (l == r) {
        res = max(res, l * 2);
      }
      if (r > l) {
        l = r = 0;
      }
    }
    l = r = 0;
    for (int i = s.size() - 1; i >= 0; i--) {
      if (s[i] == '(') {
        l++;
      } else {
        r++;
      }
      if (l == r) {
        res = max(res, l * 2);
      }
      if (l > r) {
        l = r = 0;
      }
    }
    return res;
  }

  int longestValidParentheses_stack(string s) {
    int res = 0;
    stack<int> st;
    st.push(-1);
    for (int i = 0; i < s.size(); i++) {
      if (s[i] == '(') {
        st.push(i);
      } else {
        st.pop();
        if (st.empty()) {
          st.push(i);
        } else {
          res = max(res, i - st.top());
        }
      }
    }
    return res;
  }
};
