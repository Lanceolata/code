#include <vector>

using namespace std;

class Solution {
 public:
  bool isValidSudoku(vector<vector<char>>& board) {
    size_t m = board.size(), n = board[0].size();
    vector<vector<bool>> row(m, vector<bool> (n,false));
    vector<vector<bool>> col(m, vector<bool> (n,false));
    vector<vector<bool>> area(m, vector<bool> (n,false));
    for (size_t i = 0; i < m; i++) {
      for (size_t j = 0; j < n; j++) {
        if(board[i][j] == '.') {
          continue;
        }
        size_t k = board[i][j] - '1';
        size_t p = i/3*3 + j/3;
        if (row[i][k] || col[j][k] || area[p][k]) {
          return false;
        }
        row[i][k] = col[j][k] = area[p][k] = true;
      }
    }
    return true;
  }
};
