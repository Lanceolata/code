
// Definition for a binary tree node.
struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
 public:
  void recoverTree(TreeNode* root) {
    TreeNode *s = NULL, *t = NULL, *prev = NULL;
    inorder(root, prev, s, t);
    int tmp = s->val;
    s->val = t->val;
    t->val = tmp;
  }

  void inorder(TreeNode* cur, TreeNode*& prev, TreeNode*& s, TreeNode*& t) {
    if(!cur) {
      return;
    }
    inorder(cur->left, prev, s, t);
    if(prev && prev->val >= cur->val) {
      s = s == NULL ? prev : s;
      t = cur;
    }
    prev = cur;
    inorder(cur->right, prev, s, t);
  }
};
