#include <vector>
#include <algorithm>

using namespace std;

class Solution {
 public:
  int findContentChildren(vector<int>& g, vector<int>& s) {
    if (g.empty() || s.empty()) {
      return 0;
    }
    sort(g.begin(), g.end());
    sort(s.begin(), s.end());
    int res = 0;
    for (int i = 0, j = 0; j < s.size(); j++) {
      if (s[j] >= g[i]) {
        res++;
        i++;
        if (i >= g.size()) {
          break;
        }
      }
    }
    return res;
  }
};
