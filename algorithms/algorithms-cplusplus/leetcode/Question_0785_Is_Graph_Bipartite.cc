#include <vector>
#include <queue>

using namespace std;

class Solution {
 public:
  bool isBipartite(vector<vector<int>>& graph) {
    int n = graph.size();
    vector<int> color(n);
    for (int i = 0; i < n; i++) {
      if (color[i] == 0 && !dfs(graph, color, 1, i)) {
        return false;
      }
    }
    return true;
  }

 private:
  bool dfs(vector<vector<int>>& graph, vector<int>& color, int c, int i) {
    if (color[i] != 0) {
      return color[i] == c;
    }
    color[i] = c;
    for (int j : graph[i]) {
      if (!dfs(graph, color, -c, j)) {
        return false;
      }
    }
    return true;
  }
};
