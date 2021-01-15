#include <math.h>

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
  int countNodes(TreeNode* root) {
    int left = leftHeight(root);
    int right = rightHeight(root);
    if (left == right) {
      return pow(2, left) - 1;
    }
    return countNodes(root->left) + countNodes(root->right) + 1;
  }

  int leftHeight(TreeNode* root) {
    int res = 0;
    while (root) {
      res++;
      root = root->left;
    }
    return res;
  }

  int rightHeight(TreeNode* root) {
    int res = 0;
    while (root) {
      res++;
      root = root->right;
    }
    return res;
  }
};
