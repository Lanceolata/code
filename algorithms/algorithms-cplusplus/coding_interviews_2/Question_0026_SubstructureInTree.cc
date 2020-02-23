
// Definition for a binary tree node.
struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
 public:
  bool HasSubtree(TreeNode* pRoot1, TreeNode* pRoot2) {
    if (!pRoot1 || !pRoot2) {
      return false;
    }
    if (help(pRoot1, pRoot2)) {
      return true;
    }
    return HasSubtree(pRoot1->left, pRoot2) || HasSubtree(pRoot1->right, pRoot2);
  }

  bool help(TreeNode* root1, TreeNode* root2) {
    if (!root2) {
      return true;
    }
    if (!root1) {
      return false;
    }
    if (root1->val != root2->val) {
      return false;
    }
    return help(root1->left, root2->left) && help(root1->right, root2->right);
  }
};
