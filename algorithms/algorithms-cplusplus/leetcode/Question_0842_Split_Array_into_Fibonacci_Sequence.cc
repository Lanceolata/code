#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  vector<int> splitIntoFibonacci(string num) {
    vector<int> res, cur;
    help(num, 0, cur, res);
    return res;
  }

 private:
  void help(string& num, int i, vector<int>& cur, vector<int>& res) {
    if (!res.empty()) {
      return;
    }
    if (i >= num.size() && cur.size() >= 3) {
      res = cur;
      return;
    }
    for (int j = i; j < num.size(); j++) {
      string s = num.substr(i, j - i + 1);
      if ((s.size() > 1 && s[0] == '0') || s.size() > 10) {
        break;
      }
      long n = stol(s), len = cur.size();
      if (n > INT_MAX) {
        break;
      }
      if (cur.size() >= 2 && n != (long)cur[len - 1] + cur[len - 2]) {
        continue;
      }
      cur.push_back(n);
      help(num, j + 1, cur, res);
      cur.pop_back();
    }
  }
};
