#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
 public:
  vector<int> loudAndRich(vector<vector<int>>& richer, vector<int>& quiet) {
    vector<int> res(quiet.size(), -1);
    unordered_map<int, vector<int>> richer2;
    for (vector<int> &v : richer) {
      richer2[v[1]].push_back(v[0]);
    }
    for (int i = 0; i < quiet.size(); i++) {
      dfs(i, quiet, richer2, res);
    }
    return res;
  }

 private:
  int dfs(int i, vector<int>& quiet, unordered_map<int, vector<int>>& richer2, vector<int>& res) {
    if (res[i] >= 0) {
      return res[i];
    }
    res[i] = i;
    for (int j : richer2[i]) {
      if (quiet[res[i]] > quiet[dfs(j, quiet, richer2, res)]) {
        res[i] = res[j];
      }
    }
    return res[i];
  }
};
