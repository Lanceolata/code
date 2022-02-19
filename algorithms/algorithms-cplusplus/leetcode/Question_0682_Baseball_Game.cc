#include <string>
#include <vector>
#include <stack>

using namespace std;

class Solution {
 public:
  int calPoints(vector<string>& ops) {
    stack<int> s;
    for (string op : ops) {
      if (op == "+") {
        int a = s.top();
        s.pop();
        int b = a + s.top();
        s.push(a);
        s.push(b);
      } else if (op == "C") {
        s.pop();
      } else if (op == "D") {
        s.push(2 * s.top());
      } else {
        s.push(atoi(op.c_str()));
      }
    }
    int res = 0;
    while (!s.empty()) {
      res += s.top();
      s.pop();
    }
    return res;
  }
};
