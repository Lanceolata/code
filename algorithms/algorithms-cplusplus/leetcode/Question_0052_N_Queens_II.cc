#include <vector>

using namespace std;

class Solution {
 public:
  int totalNQueens(int n) {
    vector<bool> col(n, true);
    vector<bool> anti(2*n-1, true);
    vector<bool> main(2*n-1, true);
    int count = 0;
    dfs(0, n, col, main, anti, count);
    return count;
  }

  void dfs(int i, int n, vector<bool> &col, vector<bool>& main, vector<bool> &anti, int &count) {
    if (i == n) {
      count++;
      return;
    }
    for (int j = 0; j < n; j++) {
      if (col[j] && main[i + j] && anti[i + n - 1 - j]) {
        col[j] = main[i + j] = anti[i + n - 1 - j] = false;
        dfs(i + 1, n, col, main, anti, count);
        col[j] = main[i + j] = anti[i + n - 1 - j] = true;
      }
    }
  }
};
