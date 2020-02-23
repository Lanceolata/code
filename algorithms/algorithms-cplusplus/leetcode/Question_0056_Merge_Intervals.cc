#include <vector>
#include <algorithm>

using namespace std;

class Solution {
 public:
  vector<vector<int>> merge(vector<vector<int>>& intervals) {
    vector<vector<int>> res;
    if (intervals.empty()) {
      return res;
    }
    size_t n = intervals.size();
    vector<int> starts, ends;
    for (size_t i = 0; i < n; i++) {
      starts.push_back(intervals[i][0]);
      ends.push_back(intervals[i][1]);
    }
    sort(starts.begin(), starts.end());
    sort(ends.begin(), ends.end());
    for (size_t i = 0, j = 0; i < n; i++) {
      if (i == n - 1 || starts[i + 1] > ends[i]) {
        res.push_back({starts[j], ends[i]});
        j = i + 1;
      }
    }
    return res;
  }
};
