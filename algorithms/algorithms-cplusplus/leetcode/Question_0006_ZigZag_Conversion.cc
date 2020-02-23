#include <string>

using namespace std;

class Solution {
 public:
  string convert(string s, int numRows) {
    if (s.empty() || numRows < 2) {
      return s;
    }
    string res;
    int lag = 2 * (numRows - 1);
    for (int i = 0; i < numRows; i++) {
      for (int j = i; j < s.size(); j += lag) {
        res.push_back(s[j]);
        if (i > 0 && i < numRows - 1) {
          int n = j + lag - 2 * i;
          if (n < s.size()) {
            res.push_back(s[n]);
          }
        }
      }
    }
    return res;
  }
};
