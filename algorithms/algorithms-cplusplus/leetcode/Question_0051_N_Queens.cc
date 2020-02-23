#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  vector<vector<string>> solveNQueens(int n) {
    vector<vector<string>> res;
    vector<bool> col(n, true), main(2 * n - 1, true), anti(2 * n - 1, true);
    vector<int> row(n);
    dfs(0, n, row, col, main, anti, res);
    return res;
  }

  void dfs(int i, int n, vector<int>& row, vector<bool>& col, vector<bool>& main,
      vector<bool>& anti, vector<vector<string>>& res) {
    if (i == n) {
      vector<string> vec(n, string(n, '.'));
      for (int j = 0; j < n; j++) {
        vec[j][row[j]] = 'Q';
      }
      res.push_back(vec);
      return;
    }
    for (int j = 0; j < n; j++) {
      if (col[j] && main[i + j] && anti[i + n - 1 - j]) {
        row[i] = j;
        col[j] = main[i + j] = anti[i + n - 1 - j] = false;
        dfs(i + 1, n, row, col, main, anti, res);
        col[j] = main[i + j] = anti[i + n - 1 - j] = true;
      }
    }
  }
};
