#include <vector>

using namespace std;

class Solution {
 public:
  vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
    vector<vector<int>> res;
    if (newInterval.empty()) {
      return res;
    }
    bool inserted = false;
    int b = newInterval[0], e = newInterval[1];
    for (vector<int>& i : intervals) {
      if (inserted || i[1] < b) {
        res.push_back({i[0], i[1]});
      } else if (e < i[0]) {
        inserted = true;
        res.push_back({b, e});
        res.push_back({i[0], i[1]});
      } else {
        b = min(b, i[0]);
        e = max(e, i[1]);
      }
    }
    if (!inserted) {
      res.push_back({b, e});
    }
    return res;
  }
};
