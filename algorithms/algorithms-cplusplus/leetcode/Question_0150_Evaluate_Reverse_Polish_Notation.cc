#include <string>
#include <vector>
#include <stack>

using namespace std;

class Solution {
 public:
  int evalRPN(vector<string>& tokens) {
    if (tokens.size() == 1) return atoi(tokens[0].c_str());
    stack<int> s;
    for (size_t i = 0; i < tokens.size(); i++) {
      string& token = tokens[i];
      if (token != "+" && token != "-" && token != "*" && token != "/") {
        s.push(atoi(token.c_str()));
      } else {
        int m = s.top();
        s.pop();
        int n = s.top();
        s.pop();
        if (token == "+")
          s.push(n + m);
        if (token == "-")
          s.push(n - m);
        if (token == "*")
          s.push(n * m);
        if (token == "/")
          s.push(n / m);
      }
    }
    return s.top();
  }

  int evalRPN_recursive(vector<string>& tokens) {
    int op = tokens.size() - 1;
    return helper(tokens, op);
  }

  int helper(vector<string>& tokens, int& op) {
    string s = tokens[op];
    if (s == "+" || s == "-" || s == "*" || s == "/") {
      int v2 = helper(tokens, --op);
      int v1 = helper(tokens, --op);
      if (s == "+") return v1 + v2;
      else if (s == "-") return v1 - v2;
      else if (s == "*") return v1 * v2;
      else return v1 / v2;
    } else {
      return stoi(s);
    }
  }
};
