#include <vector>
#include <stack>

using namespace std;

class Solution {
 public:
  bool validateStackSequences(vector<int>& pushed, vector<int>& popped) {
    stack<int> st;
    int n = pushed.size(), i = 0;
    for (int j = 0; j < popped.size(); j++) {
      while (i < pushed.size() && (st.empty() || st.top() != popped[j])) {
        st.push(pushed[i++]);
      }
      if (st.top() != popped[j]) {
        break;
      }
      st.pop();
    }
    return st.empty();
  }
};
