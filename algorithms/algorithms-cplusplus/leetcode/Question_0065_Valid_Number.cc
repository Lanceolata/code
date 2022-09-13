#include <string>

using namespace std;

class Solution {
 public:
  bool isNumber(string s) {
    while(!s.empty() && s[0] == ' ') {
      s.erase(s.begin());
    }
    while (!s.empty() && s[s.size() - 1] == ' ') {
      s.erase(s.end()-1);
    }
    bool pointSeen = false, eSeen = false, numberSeen = false, numberAfterE = true;
    for (int i = 0; i < s.size(); i++) {
      char c = s[i];
      if ('0' <= c && c <= '9') {
        numberSeen = true;
        numberAfterE = true;
      } else if (c == '.') {
        if (eSeen || pointSeen) {
          return false;
        }
        pointSeen = true;
      } else if (c == 'e' || c == 'E') {
        if (eSeen || !numberSeen) {
          return false;
        }
        numberAfterE = false;
        eSeen = true;
      } else if (c == '-' || c == '+') {
        if (i != 0 && s[i - 1] != 'e') {
          return false;
        }
      } else {
        return false;
      }
    }
    return numberSeen && numberAfterE;
  }
};
