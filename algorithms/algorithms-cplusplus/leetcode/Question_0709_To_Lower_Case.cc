#include <string>

using namespace std;

class Solution {
 public:
  string toLowerCase(string s) {
    for (size_t i = 0; i < s.size(); i++) {
      if (s[i] >= 'A' && s[i] <= 'Z') {
        s[i] += 32;
      }
    }
    return s;
  }
};
