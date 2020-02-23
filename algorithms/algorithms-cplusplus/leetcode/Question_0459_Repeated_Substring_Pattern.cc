#include <string>

using namespace std;

class Solution {
 public:
  bool repeatedSubstringPattern(string s) {
    if (s.empty()) {
      return false;
    }
    return (s + s).substr(1, s.size() * 2 - 2).find(s) != string::npos;
  }
};
