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
  TreeNode* Convert(TreeNode* pRootOfTree) {
    if (!pRootOfTree) {
      return pRootOfTree;
    }
    TreeNode *pre = NULL;
    stack<TreeNode*> st;
    while (pRootOfTree || !st.empty()) {
      if (pRootOfTree) {
        st.push(pRootOfTree);
        pRootOfTree = pRootOfTree->left;
      } else {
        pRootOfTree = st.top();
        st.pop();
        if (pre) {
          pre->right = pRootOfTree;
          pRootOfTree->left = pre;
        }
        pre = pRootOfTree;
        pRootOfTree = pRootOfTree->right;
      }
    }
    while (pre->left) {
      pre = pre->left;
    }
    return pre;
  }

  TreeNode* ConvertRecursive(TreeNode* pRootOfTree) {
    if (!pRootOfTree) {
      return pRootOfTree;
    }
    TreeNode *pre = NULL;
    help(pRootOfTree, &pre);
    while (pRootOfTree->left) {
      pRootOfTree = pRootOfTree->left;
    }
    return pRootOfTree;
  }

  void help(TreeNode* root, TreeNode** pre) {
    if (!root) {
      return;
    }
    help(root->left, pre);
    if (*pre) {
      (*pre)->right = root;
      root->left = (*pre);
    }
    *pre = root;
    help(root->right, pre);
  }
};
