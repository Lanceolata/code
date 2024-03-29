
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
  bool isSubtree(TreeNode* root, TreeNode* subRoot) {
    if (!root || !subRoot) {
      return root == subRoot;
    }
    if (help(root, subRoot)) {
      return true;
    }
    return help(root, subRoot) || isSubtree(root->left, subRoot) || isSubtree(root->right, subRoot);
  }

  bool help(TreeNode* root, TreeNode* subRoot) {
    if (!root || !subRoot) {
      return root == subRoot;
    } 
    if (root->val != subRoot->val) {
      return false;
    }
    return help(root->left, subRoot->left) && help(root->right, subRoot->right);
  }
};
