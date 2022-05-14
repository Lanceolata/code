
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
  bool isUnivalTree(TreeNode* root) {
    if (!root) {
      return true;
    }
    return help(root, root->val);
  }

 private:
  bool help(TreeNode* root, int val) {
    if (!root) {
      return true;
    }
    return root->val == val && help(root->left, val) && help(root->right, val);
  }
};
