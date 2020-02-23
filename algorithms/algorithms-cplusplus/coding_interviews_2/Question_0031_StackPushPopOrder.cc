#include <vector>
#include <stack>

using namespace std;

class Solution {
 public:
  bool IsPopOrder(vector<int> pushV,vector<int> popV) {
    if (pushV.size() != popV.size()) {
      return false;
    }
    stack<int> st;
    int i = 0, j = 0;
    while (j < popV.size()) {
      while (i < pushV.size() && (st.empty() || st.top() != popV[j])) {
        st.push(pushV[i++]);
      }
      if (st.top() != popV[j]) {
        return false;
      }
      st.pop();
      j++;
    }
    return true;
  }
};
