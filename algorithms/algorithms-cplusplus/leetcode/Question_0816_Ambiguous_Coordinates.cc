#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  vector<string> ambiguousCoordinates(string s) {
    int n = s.size();
    vector<string> res;
    for (int i = 1; i < n - 2; ++i) {
      vector<string> left = help(s.substr(1, i)), right = help(s.substr(i + 1, n - 2 - i));
      for (string& l : left) {
        for (string& r : right) {
          res.push_back("(" + l + ", " + r + ")");
        }
      }
    }
    return res;
  }

 private:
  vector<string> help(string s) {
    int n = s.size();
    if (n == 0 || (n > 1 && s[0] == '0' && s[n - 1] == '0')) {
      return {};
    }
    if (n > 1 && s[0] == '0') {
      return {"0." + s.substr(1)};
    }
    if (n == 1 || s[n - 1] == '0') {
      return {s};
    }
    vector<string> res = {s};
    for (int i = 1; i < n; ++i) {
      res.push_back(s.substr(0, i) + '.' + s.substr(i));
    }
    return res;
  }
};
