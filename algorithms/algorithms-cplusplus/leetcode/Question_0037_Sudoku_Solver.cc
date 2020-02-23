#include <vector>

using namespace std;

class Solution {
 public:
  void solveSudoku(vector<vector<char>>& board) {
    if (board.size() != 9 || board[0].size() != 9) {
      return;
    }
    help(board, 0, 0);
  }

  bool help(vector<vector<char>>& board, int r, int c) {
    if (r >= 9) {
      return true;
    }
    if (c >= 9) {
      return help(board, r + 1, 0);
    }
    if (board[r][c] != '.') {
      return help(board, r, c + 1);
    } else {
      for (int n = 1; n <= 9; n++) {
        board[r][c] = n + '0';
        if (isValid(board, r, c) && help(board, r, c + 1)) {
          return true;
        }
      }
      board[r][c] = '.';
    }
    return false;
  }

  bool isValid(vector<vector<char>>& board, int r, int c) {
    for (int i = 0; i < 9; i++) {
      if (i != r && board[r][c] == board[i][c]) {
        return false;
      }
    }
    for (int j = 0; j < 9; j++) {
      if (j != c && board[r][c] == board[r][j]) {
        return false;
      }
    }
    int m = r / 3 * 3, n = c / 3 * 3;
    for (int i = m; i < m + 3; i++) {
      for (int j = n; j < n + 3; j++) {
        if ((i != r || j != c) && board[i][j] == board[r][c]) {
          return false;
        }
      }
    }
    return true;
  }
};
