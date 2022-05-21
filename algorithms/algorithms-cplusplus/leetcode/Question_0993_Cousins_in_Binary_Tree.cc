#include <algorithm>

using namespace std;

// Definition for a binary tree node.
struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode() : val(0), left(nullptr), right(nullptr) {}
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
  TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
 public:
  bool isCousins(TreeNode* root, int x, int y) {
    if (checkSameParent(root, x, y)) {
      return false;
    }
    return getDepth(root, x, 0) == getDepth(root, y, 0);
  }

 private:
  bool checkSameParent(TreeNode* root, int x, int y) {
    if (!root) {
      return false;
    }
    if (root->left && root->right 
        && ((root->left->val == x && root->right->val == y) || (root->left->val == y && root->right->val == x))) {
      return true;
    }
    return checkSameParent(root->left, x, y) || checkSameParent(root->right, x, y);
  }

  int getDepth(TreeNode* root, int v, int d) {
    if (!root) {
      return -1;
    }
    if (root->val == v) {
      return d;
    }
    return max(getDepth(root->left, v, d + 1), getDepth(root->right, v, d + 1));
  }
};
