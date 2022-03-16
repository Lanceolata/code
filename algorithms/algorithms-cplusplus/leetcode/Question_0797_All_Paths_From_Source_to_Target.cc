#include <vector>

using namespace std;

class Solution {
 public:
  vector<vector<int>> allPathsSourceTarget(vector<vector<int>>& graph) {
    vector<vector<int>> paths;
    vector<int> path;
    dfs(graph, paths, path, 0);
    return paths;
  }

 private:
  void dfs(vector<vector<int>>& graph, vector<vector<int>>& res, vector<int>& path, int cur) {
    path.push_back(cur);
    if (cur == graph.size() - 1) {
      res.push_back(path);
    } else {
      for (int g : graph[cur]) {
        dfs(graph, res, path, g);
      }
    }
    path.pop_back();
  }
};
