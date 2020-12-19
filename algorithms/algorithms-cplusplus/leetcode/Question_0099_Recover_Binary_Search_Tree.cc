
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
  void recoverTree(TreeNode* root) {
    TreeNode *s = nullptr, *t = nullptr, *prev = nullptr;
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
      s = s == nullptr ? prev : s;
      t = cur;
    }
    prev = cur;
    inorder(cur->right, prev, s, t);
  }
};
