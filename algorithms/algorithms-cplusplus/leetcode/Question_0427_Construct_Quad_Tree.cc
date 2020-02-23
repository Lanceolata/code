#include <vector>

using namespace std;

class Node {
 public:
  bool val;
  bool isLeaf;
  Node* topLeft;
  Node* topRight;
  Node* bottomLeft;
  Node* bottomRight;

  Node() {}

  Node(bool _val, bool _isLeaf, Node* _topLeft, Node* _topRight, Node* _bottomLeft, Node* _bottomRight) {
    val = _val;
    isLeaf = _isLeaf;
    topLeft = _topLeft;
    topRight = _topRight;
    bottomLeft = _bottomLeft;
    bottomRight = _bottomRight;
  }
};

class Solution {
 public:
  Node* construct(vector<vector<int>>& grid) {
    if (grid.empty() || grid[0].empty()) {
      return nullptr;
    }
    return dfs(grid, 0, 0, grid.size());
  }

  Node* dfs(vector<vector<int>>& grid, int x, int y, int len) {
    if (len == 1) {
      return new Node(grid[x][y] == 1, true, nullptr, nullptr, nullptr, nullptr);
    }

    len /= 2;
    Node* topLeft = dfs(grid, x, y, len);
    Node* topRight = dfs(grid, x, y + len, len);
    Node* bottomLeft = dfs(grid, x + len, y, len);
    Node* bottomRight = dfs(grid, x + len, y + len, len);
    if (topLeft->isLeaf && topRight->isLeaf && bottomLeft->isLeaf && bottomRight->isLeaf
        && topLeft->val == topRight->val && topRight->val == bottomLeft->val
        && bottomLeft->val == bottomRight->val) {
      bool v = topLeft->val;
      delete topLeft;
      delete topRight;
      delete bottomLeft;
      delete bottomRight;
      return new Node(v, true, nullptr, nullptr, nullptr, nullptr);
    } else {
      return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
  }
};
