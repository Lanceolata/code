#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  vector<string> removeInvalidParentheses(string s) {
    vector<string> res;
    vector<char> par = {'(', ')'};
    help(s, res, 0, 0, par);
    return res;
  }

 private:
  void help(string s, vector<string>& res, int lastI, int lastJ, vector<char>& par) {
    for (int stack = 0, i = lastI; i < s.length(); ++i) {
      if (s[i] == par[0]) {
        stack++;
      }
      if (s[i] == par[1]) {
        stack--;
      }
      if (stack >= 0) {
        continue;
      }
      for (int j = lastJ; j <= i; ++j) {
        if (s[j] == par[1] && (j == lastJ || s[j - 1] != par[1])) {
          help(s.substr(0, j) + s.substr(j + 1), res, i, j, par);
        }
      }
      return;
    }
    reverse(s.begin(), s.end());
    if (par[0] == '(') {
      vector<char> opar = {')', '('};
      help(s, res, 0, 0, opar);
    } else {
      res.push_back(s);
    }
  }
};
