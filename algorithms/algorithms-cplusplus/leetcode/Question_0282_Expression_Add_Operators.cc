#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  vector<string> addOperators(string num, int target) {
    vector<string> res;
    if (!num.empty()) {
      vector<string> ops;
      help(num, target, 0, "", 0, 0, res);
    }
    return res;
  }

 private:
  void help(string& num, int target, int i, string path, long cur, long pre, vector<string>& res) {
    if (i == num.size()) {
      if (cur == target) {
        res.push_back(path);
      }
      return;
    }
    long v = 0;
    string vStr;
    for (int j = i; j < num.length(); j++) {
      if (j > i && num[i] == '0') {
        break;
      }
      v = v * 10 + (num[j] - '0');
      vStr += num[j];
      if (i == 0) {
        help(num, target, j + 1, path + vStr, v, v, res);
      } else {
        help(num, target, j + 1, path + "+" + vStr, cur + v, v, res);
        help(num, target, j + 1, path + "-" + vStr, cur - v, -v, res);
        help(num, target, j + 1, path + "*" + vStr, cur - pre + pre * v, pre * v, res);
      }
    }
  }
};
