#include <math.h>
#include <vector>

using namespace std;

class Solution {
 public:
  int maxDistance(vector<vector<int>>& arrays) {
    int gMax = arrays[0][arrays[0].size() - 1], gMin = arrays[0][0], res = 0;
    for (int i = 1; i < arrays.size(); i++) {
      vector<int>& array = arrays[i];
      int lMax = array[array.size() - 1], lMin = array[0];
      res = max(res, max(gMax - lMin, lMax - gMin));
      gMax = max(gMax, lMax);
      gMin = min(gMin, lMin);
    }
    return res;
  }
};
