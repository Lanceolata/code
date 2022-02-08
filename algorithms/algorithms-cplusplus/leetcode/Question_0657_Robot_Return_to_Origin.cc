#include <string>

using namespace std;

class Solution {
 public:
  bool judgeCircle(string moves) {
    int x = 0, y = 0;
    for (char c : moves) {
      if (c == 'L') {
        y--;
      } else if (c == 'R') {
        y++;
      } else if (c == 'U') {
        x++;
      } else if (c == 'D') {
        x--;
      }
    }
    return x == 0 && y == 0;
  }
};
