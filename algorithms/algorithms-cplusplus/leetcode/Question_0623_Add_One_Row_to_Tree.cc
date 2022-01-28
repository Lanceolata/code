
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
  TreeNode* addOneRow(TreeNode* root, int val, int depth) {
    if (depth == 1) {
      TreeNode* nRoot = new TreeNode(val, root, nullptr);
      return nRoot;
    }
    help(root, val, depth);
    return root;
  }

  void help(TreeNode* root, int val, int depth) {
    if (!root) {
      return;
    }
    depth--;
    if (depth == 1) {
      root->left = new TreeNode(val, root->left, nullptr);
      root->right = new TreeNode(val, nullptr, root->right);
    }
    if (depth > 1) {
      help(root->left, val, depth);
      help(root->right, val, depth);
      return;
    }
  }
};
