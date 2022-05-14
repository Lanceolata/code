#include <vector>
#include <string>
#include <math.h>
#include <unordered_map>
#include <limits.h>

using namespace std;

class Solution {
 public:
  double minAreaFreeRect(vector<vector<int>>& points) {
    unordered_map<string, vector<vector<int>>> m;
    for (int i = 0; i < points.size(); i++) {
      for (int j = i + 1; j < points.size(); j++) {
        double x = (points[i][0] + points[j][0]) / 2.0;
        double y = (points[i][1] + points[j][1]) / 2.0;
        string key = to_string(x) + "," + to_string(y) + "," + to_string(getDist(points, i, j));
        m[key].push_back({i, j});
      }
    }
    double res = MAXFLOAT;
    for (auto& t : m) {
      for (int i = 0; i < t.second.size(); i++) {
        for (int j = i + 1; j < t.second.size(); j++) {
          res = min(res, getArea(points, t.second[i], t.second[j]));
        }
      }
    }
    return res == MAXFLOAT ? 0 : res;
  }

 private:
  int getDist(vector<vector<int>>& p, int i, int j) {
    return (p[i][0] - p[j][0]) * (p[i][0] - p[j][0]) + (p[i][1] - p[j][1]) * (p[i][1] - p[j][1]);
  }

  double getArea(vector<vector<int>>& p, vector<int>& a, vector<int>& b) {
    int dis1 = getDist(p, a[0], b[0]);
    int dis2 = getDist(p, a[0], b[1]);
    return sqrt(dis1) * sqrt(dis2);
  }
};
