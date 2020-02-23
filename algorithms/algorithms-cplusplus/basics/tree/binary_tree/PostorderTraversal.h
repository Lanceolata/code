#include "Traversal.h"
#include <stack>

class PostorderTraversal : public Traversal {
 public:
  vector<int> traversal_recursive(TreeNode *root) {
    vector<int> res;
    traversal_recursive(root, res);
    return res;
  }

  vector<int> traversal(TreeNode *root) {
    vector<int> res;
    stack<TreeNode*> st;
    TreeNode *last = NULL;
    while (root || !st.empty()) {
      if (root) {
        st.push(root);
        root = root->left;
      } else {
          TreeNode *t = st.top();
          if (t->right && t->right != last) {
            root = t->right;
          } else {
            st.pop();
            res.push_back(t->val);
            last = t;
          }
      }
    }
    return res;
  }

 private:
  void traversal_recursive(TreeNode *root, vector<int>& res){
    if (!root) {
      return;
    }
    traversal_recursive(root->left, res);
    traversal_recursive(root->right, res);
    res.push_back(root->val);
  }
};
