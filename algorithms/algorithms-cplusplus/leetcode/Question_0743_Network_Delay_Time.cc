#include <limits.h>
#include <vector>
#include <queue>
#include <unordered_map>

using namespace std;

class Solution {
 public:
  int networkDelayTime(vector<vector<int>>& times, int n, int k) {
    for (vector<int>& t : times) {
      m[t[0]].push_back({t[2], t[1]});
    }
    vector<int> dist(n + 1, INT_MAX);
    dijkstra(dist, k);
    int res = INT_MIN;
    for (int i = 1; i <= n; i++) {
      res = max(res, dist[i]);
    }
    return res == INT_MAX ? -1 : res;
  }

 private:
  unordered_map<int, vector<pair<int, int>>> m;

  void dijkstra(vector<int>& dist, int source) {
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    pq.push({0, source});
    dist[source] = 0;
    while (!pq.empty()) {
      pair<int, int> p = pq.top();
      pq.pop();
      int t = p.first;
      int s = p.second;
      if (t > dist[s]) {
        continue;
      }
      for (pair<int, int>& pp : m[s]) {
        int tt = pp.first;
        int ss = pp.second;
        if (dist[ss] > t + tt) {
          dist[ss] = t + tt;
          pq.push({t + tt, ss});
        }
      }
    }
  }
};
