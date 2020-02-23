#include <vector>
#include <queue>

using namespace std;

class Solution {
 public:
  bool canFinish(int numCourses, vector<pair<int, int>>& prerequisites) {
    if (prerequisites.empty()) {
      return true;
    }
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
    while (!que.empty()) {
      int u = que.front();
      que.pop();
      for (auto v : graph[u]) {
        --inDegree[v];
        if (inDegree[v] == 0) que.push(v);
      }
    }
      for (int i = 0; i < numCourses; ++i) {
        if (inDegree[i] != 0) return false;
      }
    return true;
  }
};
