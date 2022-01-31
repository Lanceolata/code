#include <string>

using namespace std;

class Solution {
 public:
  string predictPartyVictory(string senate) {
    int r = 0, d = 0, start = 0;
    for (char c : senate) {
      if (c == 'R') {
        r++;
      } else {
        d++;
      }
    }
    while (r > 0 && d > 0) {
      while (senate[start] == ' ') {
        start = (start + 1) % senate.size();
      }
      char ban = 'R';
      if (senate[start] == 'R') {
        ban = 'D';
        d--;
      } else {
        r--;
      }
      int idx = (start + 1) % senate.size();
      while (senate[idx] != ban) {
        idx = (idx + 1) % senate.size();
      }
      senate[idx] = ' ';
      start = (start + 1) % senate.size();
    }
    return d == 0 ? "Radiant" : "Dire";
  }
};
