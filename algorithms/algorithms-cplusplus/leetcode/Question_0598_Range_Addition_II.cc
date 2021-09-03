#include <vector>

using namespace std;

class Solution {
 public:
  int maxCount(int m, int n, vector<vector<int>>& ops) {
    if (ops.empty()) {
      return m * n;
    }
    int r = INT_MAX, c = INT_MAX;
    for (vector<int>& v : ops) {
      r = min(r, v[0]);
      c = min(c, v[1]);
    }
    return r * c;
  }
};
