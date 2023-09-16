
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
  int sumRootToLeaf(TreeNode* root) {
    int res = 0;
    help(root, 0, res);
    return res;
  }

  void help(TreeNode* root, int pre, int& res) {
    if (!root) {
      return;
    }
    pre = (pre << 1) | root->val;
    if (root->left || root->right) {
      help(root->left, pre, res);
      help(root->right, pre, res);
    } else {
      res += pre;
    }
  }
};
