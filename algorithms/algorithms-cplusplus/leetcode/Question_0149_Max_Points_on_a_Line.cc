#include <limits.h>
#include <utility>
#include <vector>
#include <algorithm>
#include <unordered_map>
#include <string>

using namespace std;

class Solution {
 public:
  int maxPoints(vector<vector<int>>& points) {
    if (points.size() < 3) {
      return points.size();
    }
    int res = 1;
    for (int i = 0; i < points.size(); i++) {
      res = max(help(points, i), res);
    }
    return res;
  }

 private:
  int help(vector<vector<int>>& points, int i) {
    unordered_map<string, int> m;
    int horizontalLines = 1;

    int count = 1;
    int duplicates = 0;
    for (int j = i + 1; j < points.size(); j++) {
      addLine(points, i, j, count, duplicates, horizontalLines, m);
    }
    return count + duplicates;
  }

  void addLine(vector<vector<int>>& points, int i, int j, int& count, int& duplicates,
               int& horizontalLines, unordered_map<string, int>& m) {
    int x1 = points[i][0];
    int y1 = points[i][1];
    int x2 = points[j][0];
    int y2 = points[j][1];
    if ((x1 == x2) && (y1 == y2)) {
      // 两个点重复时，该点的任意一条直线上的点都应该+1。因此用一个变量dup来保存于当前点重复的点
      duplicates++;
    } else if (y1 == y2) {
      // 平行于x轴
      horizontalLines += 1;
      count = max(horizontalLines, count);
    } else {
      string slope = getSlope(x1, y1, x2, y2);
      m[slope]++;
      count = max(m[slope] + 1, count);
    }
  }

  string getSlope(int x1, int y1, int x2, int y2) {
    int deltaX = x1 - x2, deltaY = y1 - y2;
    if (deltaX == 0) {
      return "0#0";
    } else if (deltaY == 0) {
      return to_string(INT_MAX) + "#" + to_string(INT_MAX);
    } else if (deltaX < 0) {
      deltaX = -deltaX;
      deltaY = -deltaY;
    }
    int gcd = __gcd(deltaX, deltaY);
    return to_string(deltaX / gcd) + "#" +  to_string(deltaY / gcd);
  }
};
