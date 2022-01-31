#include <vector>

using namespace std;

class Solution {
 public:
  int findLongestChain(vector<vector<int>>& pairs) {
    sort(pairs.begin(), pairs.end(), cmp);
    int cur = pairs[0][0] - 1, res = 0;
    for (vector<int> p : pairs) {
      if (cur < p[0]) {
          cur = p[1];
          res++;
      }
    }
    return res;
  }

 private:
  static bool cmp(vector<int>& a, vector<int>&b) {
    return a[1] < b[1] || a[1] == b[1] && a[0] < b[0];
  }
};
