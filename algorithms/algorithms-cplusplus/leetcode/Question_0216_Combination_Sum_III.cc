#include <vector>

using namespace std;

class Solution {
 public:
  vector<vector<int>> combinationSum3(int k, int n) {
    vector<int> vec;
    vector<vector<int>> res;
    helper(k, n, 1, vec, res);
    return res;
  }

  void helper(int k, int n, int level, vector<int>& vec, vector<vector<int>>& res) {
    if (n < 0) {
      return;
    }
    if (n == 0 && vec.size() == k) {
      res.push_back(vec);
      return;
    }
    for (int i = level; i <= 9; i++) {
      vec.push_back(i);
      helper(k, n - i, i + 1, vec, res);
      vec.pop_back();
    }
  }
};
