#include "Traversal.h"
#include <stack>

class PreorderTraversal : public Traversal {
 public:
  vector<int> traversal_recursive(TreeNode *root) {
    vector<int> res;
    traversal_recursive(root, res);
    return res;
  }

  vector<int> traversal(TreeNode *root) {
    vector<int> res;
    stack<TreeNode*> st;
    while (root || !st.empty()) {
      if (root) {
        res.push_back(root->val);
        st.push(root);
        root = root->left;
      } else {
        root = st.top();
        st.pop();
        root = root->right;
      }
    }
    return res;
  }

 private:
  void traversal_recursive(TreeNode *root, vector<int>& res){
    if (!root) {
      return;
    }
    res.push_back(root->val);
    traversal_recursive(root->left, res);
    traversal_recursive(root->right, res);
  }
};
