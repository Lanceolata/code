#include <vector>

using namespace std;

class Solution {
 public:
  int maxScoreSightseeingPair(vector<int>& values) {
    int res = 0, cur = 0;
    for (int v : values) {
      res = max(res, cur + v);
      cur = max(cur, v) - 1;
    }
    return res;
  }
};
