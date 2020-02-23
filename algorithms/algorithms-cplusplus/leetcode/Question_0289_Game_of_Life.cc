#include <vector>

using namespace std;

class Solution {
 public:
  void gameOfLife(vector<vector<int>>& board) {
    if (board.empty() || board[0].empty()) {
      return;
    }
    int m = board.size(), n = board[0].size();
    int dx[] = {-1, -1, -1, 0, 1, 1, 1, 0};
    int dy[] = {-1, 0, 1, 1, 1, 0, -1, -1};
    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        int cnt = 0;
        for (int k = 0; k < 8; ++k) {
          int x = i + dx[k], y = j + dy[k];
          if (x >= 0 && x < m && y >= 0 && y < n && (board[x][y] == 1 || board[x][y] == 2)) {
            ++cnt;
          }
        }
        // 2 表示当前live 之后dead
        // 3 表示当前dead 之后live
        if (board[i][j] && (cnt < 2 || cnt > 3)) {
          board[i][j] = 2;
        } else if (!board[i][j] && cnt == 3) {
          board[i][j] = 3;
        }
      }
    }
    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        board[i][j] %= 2;
      }
    }
  }
};
