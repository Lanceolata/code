#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
 public:
  int numberOfBoomerangs(vector<vector<int>>& points) {
    if (points.empty()) {
      return 0;
    }
    int res = 0;
    unordered_map<int, int> count;
    for (size_t i = 0; i < points.size(); i++) {
      for (size_t j = 0; j < points.size(); j++) {
        if (i == j) {
          continue;
        }
        int d = distance(points[i], points[j]);
        ++count[d];
      }

      for (auto it = count.begin(); it != count.end(); it++) {
        res += it->second * (it->second - 1);
      }
      count.clear();
    }
    return res;
  }

  int distance(vector<int>& v1, vector<int>& v2) {
    int dx = v1[0] - v2[0];
    int dy = v1[1] - v2[1];
    return dx * dx + dy * dy;
  }
};
