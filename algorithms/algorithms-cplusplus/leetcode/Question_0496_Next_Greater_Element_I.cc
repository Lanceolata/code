#include <vector>
#include <stack>
#include <unordered_map>

using namespace std;

class Solution {
 public:
  vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
    unordered_map<int, int> m;
    stack<int> st;
    vector<int> res;
    for (int num : nums2) {
      while (!st.empty() && st.top() < num) {
        m[st.top()] = num; st.pop();
      }
      st.push(num);
    }
    for (int num : nums1) {
      res.push_back(m.count(num) ? m[num] : -1);
    }
    return res;
  }
};
