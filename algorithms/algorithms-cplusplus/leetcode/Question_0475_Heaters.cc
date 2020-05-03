#include <vector>
#include <algorithm>

using namespace std;

class Solution {
 public:
  int findRadius(vector<int>& houses, vector<int>& heaters) {
    int res = 0, n = heaters.size();
    sort(heaters.begin(), heaters.end());
    for (int house : houses) {
      int l = 0, r = n, m;
      while (l < r) {
        m = l + (r - l) / 2;
        if (heaters[m] < house) {
          l = m + 1;
        } else {
          r = m;
        }
      }
      int dist1 = (r == n) ? INT_MAX : heaters[r] - house;
      int dist2 = (r == 0) ? INT_MAX : house - heaters[r - 1];
      res = max(res, min(dist1, dist2));
    }
    return res;
  }
};
