#include <vector>
#include <map>
#include <set>

using namespace std;

class Solution {
 public:
  vector<vector<int>> getSkyline(vector<vector<int>>& buildings) {
	vector<vector<int>> res;
	vector<pair<int, int>> walls;
    for (auto b : buildings) {
      walls.push_back(make_pair(b[0], -b[2]));
      walls.push_back(make_pair(b[1], b[2]));
    }
    sort(walls.begin(), walls.end());
	multiset<int> leftWallHeights = {0};
    int top = 0;
    for (auto w : walls) {
      if (w.second < 0) {
        leftWallHeights.insert(-w.second);
      } else {
        leftWallHeights.erase(leftWallHeights.find(w.second));
      }
      if (*leftWallHeights.rbegin() != top) {
        res.push_back({w.first, top = *leftWallHeights.rbegin()});
      }
    }
    return res;
  }
};
