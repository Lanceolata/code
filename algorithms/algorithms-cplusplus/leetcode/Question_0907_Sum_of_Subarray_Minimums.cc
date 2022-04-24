#include <vector>
#include <stack>

using namespace std;

class Solution {
 public:
  int sumSubarrayMins(vector<int>& arr) {
    stack<int> s;
    vector<int> dp(arr.size() + 1);
    s.push(-1);
    int res = 0, M = (int)1e9 + 7;
    for (int i = 0; i < arr.size(); i++) {
      while (s.top() != -1 && arr[i] <= arr[s.top()]) {
        s.pop();
      }
      dp[i + 1] = (dp[s.top() + 1] + (i - s.top()) * arr[i]) % M;
      s.push(i);
      res = (res + dp[i + 1]) % M;
    }
    return res;
  }
};
