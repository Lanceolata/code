#include <vector>
#include <algorithm>

using namespace std;

class Solution {
 public:
  vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
    sort(candidates.begin(), candidates.end());
    vector<vector<int>> res;
    vector<int> vec;
    help(candidates, target, 0, vec, res);
    return res;
  }

  void help(vector<int>& candidates, int target, size_t index,
      vector<int>& vec, vector<vector<int>>& res) {
    if (target == 0) {
      res.push_back(vec);
      return;
    }
    for (size_t i = index; i < candidates.size(); i++) {
      if (candidates[i] > target) {
        return;
      }
      if (i > index && candidates[i] == candidates[i - 1]) {
        continue;
      }
      vec.push_back(candidates[i]);
      help(candidates, target - candidates[i], i + 1, vec, res);
      vec.pop_back();
    }
  }
};
