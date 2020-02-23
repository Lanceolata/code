#include <vector>
#include <stack>

using namespace std;

class Solution {
 public:
  int largestRectangleArea(vector<int>& heights) {
    if (heights.empty()) {
      return 0;
    }
    stack<int> st;
    int res = 0;
    for (int i = 0; i <= heights.size(); i++) {
      int cur = (i == heights.size()) ? 0 : heights[i];
      while (!st.empty() && heights[st.top()] >= cur) {
        int h = heights[st.top()];
        st.pop();
        int w = st.empty() ? i : i - st.top() - 1;
        res = max(res, h * w);
      }
      st.push(i);
    }
    return res;
  }
};
