#include <string>
#include <sstream>

using namespace std;

class Solution {
 public:
  string reverseWords(string s) {
    istringstream is(s);
    string res = "", t;
    while (is >> t) {
      res = t + " " + res;
    }
    if (!res.empty()) {
      res.pop_back();
    }
    return res;
  }
};
