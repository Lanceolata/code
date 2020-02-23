#include <vector>

using namespace std;

class Solution {
 public:
  vector<vector<int>> combine(int n, int k) {
    vector<vector<int>> res;
    vector<int> vec;
    help(1, n, k, vec, res);
    return res;
  }

  void help(int start, int n, int k, vector<int>& vec, vector<vector<int>>& res) {
    if (k == 0) {
      res.push_back(vec);
      return;
    }
    for (int i = start; i <= n; i++) {
      vec.push_back(i);
      help(i + 1, n, k - 1, vec, res);
      vec.pop_back();
    }
  }
};
