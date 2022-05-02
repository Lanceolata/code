#include <limits.h>
#include <vector>
#include <unordered_map>
#include <unordered_set>

using namespace std;

class Solution {
 public:
  int minAreaRect(vector<vector<int>>& points) {
    unordered_map<int, unordered_set<int>> m;
    for (vector<int>& p : points) {
      m[p[0]].insert(p[1]);
    }
    int res = INT_MAX;
    for (vector<int>& p1 : points) {
      for (vector<int>& p2 : points) {
        if (p1[0] == p2[0] || p1[1] == p2[1]) {
          continue;
        }
        if (m[p1[0]].count(p2[1]) && m[p2[0]].count(p1[1])) {
          res = min(res, abs(p1[0] - p2[0]) * abs(p1[1] - p2[1]));
        }
      }
    }
    return res == INT_MAX ? 0 : res;
  }
};
