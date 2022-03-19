#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  vector<int> numberOfLines(vector<int>& widths, string s) {
    int cur = 0;
    vector<int> res = {0, 101};
    for (char c : s) {
      if (cur + widths[c - 'a'] > 100) {
        res[0]++;
        res[1] = min(res[1], cur);
        cur = 0;
      }
      cur += widths[c - 'a'];
    }
    if (cur != 0) {
      res[0]++;
      res[1] = min(res[1], cur);
    }
    return res;
  }
};
