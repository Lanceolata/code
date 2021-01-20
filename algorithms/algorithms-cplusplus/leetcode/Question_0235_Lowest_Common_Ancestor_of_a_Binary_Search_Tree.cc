
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
  TreeNode* lowestCommonAncestorRecursive(TreeNode* root, TreeNode* p, TreeNode* q) {
    if (p->val < root->val && q->val < root->val) {
      return lowestCommonAncestorRecursive(root->left, p, q);
    }
    if (p->val > root->val && q->val > root->val) {
      return lowestCommonAncestorRecursive(root->right, p, q);
    }
    return root;
  }
  
  TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
    while (root) {
      if (root->val > p->val && root->val > q->val) {
        root = root->left;
      } else if (root->val < p->val && root->val < q->val) {
        root = root->right;
      } else {
        break;
      }
    }
    return root;
  }
};
