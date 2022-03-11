#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  vector<string> letterCasePermutation(string s) {
    vector<string> res;
    help(s, 0, res);
    return res;
  }

 private:
  void help(string& s, int i, vector<string>& res) {
    if (i >= s.size()) {
      res.push_back(s);
      return;
    }
    char c = s[i];
    help(s, i + 1, res);
    if (c >= 'a' && c <= 'z') {
      s[i] -= 32;
      help(s, i + 1, res);
    } else if (c >= 'A' && c <= 'Z') {
      s[i] += 32;
      help(s, i + 1, res);
    }
    s[i] = c;
  }
};
