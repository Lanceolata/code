#include <string>

using namespace std;

class Solution {
 public:
  bool checkRecord(string s) {
    int cl = 0, ca = 0;
    for (int i = 0; i < s.size(); i++) {
      if (s[i] == 'L') {
        if (++cl >= 3) {
          return false;
        }
        continue;
      }
      if (s[i] == 'A') {
        ca++;
      }
      cl = 0;
    }
    return ca < 2;
  }
};
