#include <vector>

using namespace std;

class Solution {
 public:
  vector<vector<char>> updateBoard(vector<vector<char>>& board, vector<int>& click) {
    int m = board.size(), n = board[0].size();
    int row = click[0], col = click[1];
    if (board[row][col] == 'M') {
      board[row][col] = 'X';
    } else {
      int count = 0;
      for (int i = -1; i < 2; i++) {
        for (int j = -1; j < 2; j++) {
          int x = row + i, y = col + j;
          if (x < 0 || x >= m || y < 0 || y >= n) {
            continue;
          }
          if (board[x][y] == 'M') {
            count++;
          }
        }
      }
      if (count) {
        board[row][col] = count + '0';
      } else {
        board[row][col] = 'B';
        for (int i = -1; i < 2; i++) {
          for (int j = -1; j < 2; j++) {
            int x = row + i, y = col + j;
            if (x < 0 || x >= m || y < 0 || y >= n) {
              continue;
            }
            if (board[x][y] == 'E') {
              vector<int> next = {x, y};
              updateBoard(board, next);
            }
          }
        }
      }
    }
    return board;
  }
};
