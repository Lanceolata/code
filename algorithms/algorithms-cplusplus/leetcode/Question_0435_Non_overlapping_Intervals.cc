#include <vector>

using namespace std;

class Solution {
 public:
  int eraseOverlapIntervals(vector<vector<int>>& intervals) {
    if (intervals.empty()) {
      return 0;
    }
    auto comp = [](const vector<int>& i1, const vector<int>& i2){ return i1[1] < i2[1]; };
    sort(intervals.begin(), intervals.end(), comp);
    int res = 1, end = intervals[0][1];
    for (int i = 1; i < intervals.size(); i++) {
      if (intervals[i][0] >= end) {
        end = intervals[i][1];
        res++;
      }
    }
    return intervals.size() - res;
  }
};
