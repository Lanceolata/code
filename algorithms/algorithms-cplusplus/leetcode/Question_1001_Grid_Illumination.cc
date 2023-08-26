#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
 public:
  vector<vector<int>> dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}, {0, 0}};

  vector<int> gridIllumination(int n, vector<vector<int>>& lamps, vector<vector<int>>& queries) {
    unordered_map<long long, long long> m1, m2, m3, m4, m5;
    // increment counters while adding lamps
    for (int i = 0; i < lamps.size(); i++) {
      long long x = lamps[i][0];
      long long y = lamps[i][1];
      m1[x] += 1;
      m2[y] += 1;
      m3[x - y] += 1;
      m4[x + y] += 1;
      m5[n * x + y] += 1;
    }

    vector<int> ans(queries.size(), 0);
    // address queries
    for (int i = 0; i < queries.size(); i++) {
      long long x = queries[i][0];
      long long y = queries[i][1];
      ans[i] = (m1[x] > 0 || m2[y] > 0 || m3[x - y] > 0 || m4[x + y] > 0) ? 1 : 0;
      for (int d = 0; d < dirs.size(); d++) {
        long long x1 = x + dirs[d][0];
        long long y1 = y + dirs[d][1];
        if (x1 >= 0 && y1 >= 0 && x1 < n && y1 < n && m5.count(n * x1 + y1) > 0) {
          long long times = m5[n * x1 + y1];
          m1[x1] = (m1.count(x1) > 0 ? m1[x1] : 1) - times;
          m2[y1] = (m2.count(y1) > 0 ? m2[y1] : 1) - times;
          m3[x1 - y1] = (m3.count(x1 - y1) > 0 ? m3[x1 - y1] : 1) - times;
          m4[x1 + y1] = (m4.count(x1 + y1) > 0 ? m4[x1 + y1] : 1) - times;
          m5.erase(n * x1 + y1);
        }
      }
    }

    return ans;
  }
};
