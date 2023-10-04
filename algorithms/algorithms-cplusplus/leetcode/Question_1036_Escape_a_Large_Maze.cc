#include <vector>
#include <unordered_set>

using namespace std;

class Solution {
 public:
  bool isEscapePossible(vector<vector<int>>& blocked, vector<int>& source, vector<int>& target) {
    unordered_set<long long> vis_s, vis_t;
    for (auto b : blocked) {
      if (abs(b[0] - source[0]) + abs(b[1] - source[1]) < 400) {
        vis_s.insert(((long long)b[0] << 32) + b[1]);
      }
      if (abs(b[0] - target[0]) + abs(b[1] - target[1]) < 400) {
        vis_t.insert(((long long)b[0] << 32) + b[1]);
      }
    }
    return bfs(vis_s, source, target, vis_s.size()) && bfs(vis_t, target, source, vis_t.size());
  }

  bool bfs(unordered_set<long long> &visited, vector<int>& s, vector<int>& t, int blocks) {
    vector<vector<int>> dirs = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
    vector<pair<int, int>> q = { {s[0], s[1]} };
    while (!q.empty() && q.size() <= blocks) {
      vector<pair<int, int>> q1;
      for (auto p : q) {
        for (auto d : dirs) {
          auto x = p.first + d[0], y = p.second + d[1];
          if (x < 0 || x > 999999 || y < 0 || y > 999999) {
            continue;
          }
          if (x == t[0] && y == t[1]) {
            return true;
          }
          if (visited.insert(((long long)x << 32) + y).second) {
            q1.push_back({ x, y });
          }
        }
      }
      swap(q, q1);
    }
    return !q.empty();
  }
};
