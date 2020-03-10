#include <vector>
#include <algorithm>

using namespace std;

class Solution {
 public:
  int findMinArrowShots(vector<vector<int>>& points) {
    if (points.empty()) {
      return 0;
    }
    sort(points.begin(), points.end(), [](vector<int>& a, vector<int>& b){return a[1] < b[1];});
    int res = 1, end = points[0][1];
    for (int i = 1; i < points.size(); i++) {
      if (end >= points[i][0]) {
        continue;
      }
      res++;
      end = points[i][1];
    }
    return res;
  }
};
