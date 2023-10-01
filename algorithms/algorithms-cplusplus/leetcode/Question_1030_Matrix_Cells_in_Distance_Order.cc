#include <vector>
#include <queue>

using namespace std;

class Solution {
 public:
  vector<vector<int>> allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
    vector<vector<int>> res;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        res.push_back({i, j, abs(i - rCenter) + abs(j - cCenter)});
      }
    }
    sort(res.begin(), res.end(), [](vector<int>& c1, vector<int>& c2) {
      return c1[2] < c2[2];
    });
    for (vector<int>& d: res) {
      d.pop_back();
    }
    return res;
  }
};
