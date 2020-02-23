#include <stack>

using namespace std;

// Definition for a binary tree node.
struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class BSTIterator {
 public:
  BSTIterator(TreeNode *root) {
    while (root) {
      s.push(root);
      root = root->left;
    }
  }

  /** @return whether we have a next smallest number */
  bool hasNext() {
    return !s.empty();
  }

  /** @return the next smallest number */
  int next() {
    TreeNode *n = s.top();
    s.pop();
    int res = n->val;
    if (n->right) {
      n = n->right;
      while (n) {
        s.push(n);
        n = n->left;
      }
    }
    return res;
  }

 private:
  stack<TreeNode*> s;
};
