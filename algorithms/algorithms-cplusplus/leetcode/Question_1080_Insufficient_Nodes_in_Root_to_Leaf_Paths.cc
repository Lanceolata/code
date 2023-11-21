
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
  TreeNode* sufficientSubset(TreeNode* root, int limit) {
    bool valid = help(root, limit, 0);
    return valid ? root : nullptr;
  }

  bool help(TreeNode* root, int limit, int pre) {
    if (!root) {
      return false;
    }
    pre += root->val;
    if (root->left == nullptr && root->right == nullptr) {
      return pre >= limit;
    }
    bool left = help(root->left, limit, pre);
    bool right = help(root->right, limit, pre);
    if (!left) {
      root->left = nullptr;
    }
    if (!right) {
      root->right = nullptr;
    }
    if (left || right) {
      return true;
    }
    return false;
  }
};
