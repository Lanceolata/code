#include <vector>

using namespace std;

class Solution {
 public:
  vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
    int n = graph.size();
    // 0 未遍历 1 正在遍历 2 已遍历结束
    vector<int> color(n, 0), res;
    for (int i = 0; i < n; i++) {
      if (dfs(graph, i, color)) {
        res.push_back(i);
      }
    }
     return res;
  }

 private:
  bool dfs(vector<vector<int>>& graph, int i, vector<int>& color) {
    if (color[i] > 0) {
      return color[i] == 2;
    }
    color[i] = 1;
    for (int j : graph[i]) {
      if (color[j] == 1 || !dfs(graph, j, color)) {
        return false;
      }
    }
    color[i] = 2;
    return true;
  }
};
