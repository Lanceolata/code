#include <vector>
#include <unordered_set>

using namespace std;

class Solution {
 public:
  int flipgame(vector<int>& fronts, vector<int>& backs) {
    unordered_set<int> same;
    for (int i = 0; i < fronts.size(); ++i) {
      if (fronts[i] == backs[i]) {
        same.insert(fronts[i]);
      }
    }
    int res = INT_MAX;
    for (int front : fronts) {
      if (!same.count(front)) {
        res = min(res, front);
      }
    }
    for (int back : backs) {
      if (!same.count(back)) {
        res = min(res, back);
      }
    }
    return (res == INT_MAX) ? 0 : res;
  }
};
