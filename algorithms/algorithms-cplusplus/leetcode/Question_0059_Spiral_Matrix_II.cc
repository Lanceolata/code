#include <vector>

using namespace std;

class Solution {
 public:
  vector<vector<int>> generateMatrix(int n) {
    if (n <= 0) return vector<vector<int>>();
    vector<vector<int>> res = vector<vector<int>>(n, vector<int>(n));
    int r1 = 0, r2 = n - 1, c1 = 0, c2 = n - 1, v = 1;
    while (r1 <= r2 && c1 <= c2) {
      for (int i = c1; i <= c2; i++) {
        res[r1][i] = v++;
      }
      for (int i = r1 + 1; i <= r2; i++) {
        res[i][c2] = v++;
      }
      for (int i = c2 - 1; i >= c1; i--) {
        res[r2][i] = v++;
      }
      for (int i = r2 - 1; i > r1; i--) {
        res[i][c1] = v++;
      }
      r1++; r2--; c1++; c2--;
    }
    return res;
  }
};
