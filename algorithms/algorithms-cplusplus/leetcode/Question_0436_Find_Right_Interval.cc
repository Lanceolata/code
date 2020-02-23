#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
 public:
  vector<int> findRightInterval(vector<vector<int>>& intervals) {
    if (intervals.empty()) {
      return {};
    }
    vector<int> res, starts;
    unordered_map<int, int> m;
    for (int i = 0; i < intervals.size(); ++i) {
      m[intervals[i][0]] = i;
      starts.push_back(intervals[i][0]);
    }
    sort(starts.begin(), starts.end());
    for (auto interval : intervals) {
      int t = binarySearch(starts, interval[1]);
      if (t < 0 || t >= starts.size()) {
        res.push_back(-1);
      } else {
        res.push_back(m[starts[t]]);
      }
    }
    return res;
  }

  int binarySearch(vector<int>& vec, int v) {
    int l = 0, r = vec.size() - 1, m;
    while (l <= r) {
      m = l + (r - l) / 2;
      if (vec[m] < v) {
        l = m + 1;
      } else {
        r = m - 1;
      }
    }
    return l;
  }
};
