#include <stack>

using namespace std;

// Definition for a binary tree node.
struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
 public:
  bool isValidBST(TreeNode* root) {
    stack<TreeNode*> st;
    TreeNode *pre = NULL;
    while (root || !st.empty()) {
      if (root) {
        st.push(root);
        root = root->left;
      } else {
        root = st.top();
        st.pop();
        if (pre && pre->val >= root->val) {
          return false;
        }
        pre = root;
        root = root->right;
      }
    }
    return true;
  }
};
