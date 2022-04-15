#include <vector>

using namespace std;

class Solution {
 public:
  bool possibleBipartition(int n, vector<vector<int>>& dislikes) {
    vector<vector<int>> g(n + 1, vector<int>(n + 1));
    for (auto d : dislikes) {
      g[d[0]][d[1]] = 1;
      g[d[1]][d[0]] = 1;
    }
    vector<int> colors(n + 1);
    for (int i = 1; i <= n; ++i) {
      if (colors[i] == 0 && !help(g, i, 1, colors)) {
        return false;
      }
    }
    return true;
  }

 private:
  bool help(vector<vector<int>>& g, int cur, int color, vector<int>& colors) {
    colors[cur] = color;
    for (int i = 0; i < g.size(); ++i) {
      if (g[cur][i] == 1) {
        if (colors[i] == color) {
          return false;
        }
        if (colors[i] == 0 && !help(g, i, -color, colors)) {
          return false;
        }
      }
    }
    return true;
  }
};
