#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  int lengthOfLongestSubstring(string s) {
    int l = -1, res = 0;
    vector<int> map(256, -1);
    for (int i = 0; i < s.size(); i++) {
      l = max(l, map[s[i]]);
      res = max(res, i - l);
      map[s[i]] = i;
    }
    return res;
  }
};
