
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
  TreeNode* increasingBST(TreeNode* root) {
    if (!root) {
      return root;
    }
    TreeNode res(0);
    TreeNode* p = &res;
    inorder(root, p);
    return res.right;
  }

 private:
  void inorder(TreeNode* root, TreeNode*& cur) {
    if (!root) {
      return;
    }
    inorder(root->left, cur);
    root->left = nullptr;
    cur->right = root;
    cur = root;
    inorder(root->right, cur);
  }
};
