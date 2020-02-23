#include <vector>
#include <string>

using namespace std;

class Solution {
 public:
  bool exist(vector<vector<char>>& board, string word) {
    vector<vector<bool>> visited(board.size(), vector<bool>(board[0].size()));
    for (int i = 0; i < board.size(); i++) {
      for (int j = 0; j < board[0].size(); j++) {
        if (isThisWay(board, word, i, j, 0, visited)) {
          return true;
        }
      }
    }
    return false;
  }

  bool isThisWay(vector<vector<char>>& board, string& word, int row,
      int column, int index, vector<vector<bool>>& visited) {
    if (row < 0 || row >= board.size() || column < 0 || column >= board[0].size()
        || visited[row][column] || board[row][column] != word[index]) {
      return false;
    }
  
    if (++index == word.size()) {
      return true;
    }
    visited[row][column] = true;
    if (isThisWay(board, word, row - 1, column, index, visited) ||
        isThisWay(board, word, row + 1, column, index, visited) ||
        isThisWay(board, word, row, column - 1, index, visited) ||
        isThisWay(board, word, row, column + 1, index, visited)) {
      return true;
    }
    visited[row][column] = false;
    return false;
  }
};
