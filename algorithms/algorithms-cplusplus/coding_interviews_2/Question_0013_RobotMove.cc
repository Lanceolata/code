#include <vector>

using namespace std;

class Solution {
 public:
  int movingCount(int threshold, int rows, int cols) {
    if (threshold < 0 || rows <= 0 || cols <= 0) {
      return 0;
    }
    vector<vector<bool>> vesited(rows, vector<bool>(cols, false));
    return help(threshold, rows, cols, 0, 0, vesited);
  }

  int help(int threshold, int rows, int cols, int r, int c, vector<vector<bool>>& vesited) {
    if (r < 0 || r >= rows || c < 0 || c >= cols) {
      return 0;
    }
    if (vesited[r][c] || count(r) + count(c) > threshold) {
      return 0;
    }
    int res = 0;
    vesited[r][c] = true;
    res += help(threshold, rows, cols, r - 1, c, vesited);
    res += help(threshold, rows, cols, r + 1, c, vesited);
    res += help(threshold, rows, cols, r, c - 1, vesited);
    res += help(threshold, rows, cols, r, c + 1, vesited);
    return res + 1;
  }

  int count(int n) {
    int res = 0;
    while (n) {
      res += n % 10;
      n /= 10;
    }
    return res;
  }
};
