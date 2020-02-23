#include <vector>
#include <queue>

using namespace std;

class Solution {
 public:
  vector<int> findOrder(int numCourses, vector<pair<int, int>>& prerequisites) {
    vector<vector<int>> graph(numCourses, vector<int>(0));
    vector<int> inDegree(numCourses, 0);
    for (auto u : prerequisites) {
      graph[u.second].push_back(u.first);
      ++inDegree[u.first];
    }
    queue<int> que;
    for (int i = 0; i < numCourses; ++i) {
      if (inDegree[i] == 0) que.push(i);
    }
    vector<int> res;
    while (!que.empty()) {
      int u = que.front();
      que.pop();
      res.push_back(u);
      for (auto v : graph[u]) {
        --inDegree[v];
        if (inDegree[v] == 0) que.push(v);
      }
    }
    for (int i = 0; i < numCourses; ++i) {
      if (inDegree[i] != 0) return vector<int>();
    }
    return res;
  }
};
