#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  vector<string> generateParenthesis(int n) {
    vector<string> res;
    help("", 0, 0, n, res);
    return res;
  }

  void help(string pre, int open, int close, int max, vector<string>& res) {
    if (pre.size() == max * 2) {
      res.push_back(pre);
      return;
    }
    if (open < max) {
      help(pre + "(", open + 1, close, max, res);
    }
    if (close < open) {
      help(pre + ")", open, close + 1, max, res);
    }
  }
};
