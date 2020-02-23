#include <vector>

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
  vector<int> postorderTraversal(TreeNode* root) {
    vector<int> res;
    if (!root) {
      return res;
    }
    stack<TreeNode*> s;
    TreeNode* last = NULL;
    while (root || !s.empty()) {
      if (root) {
        s.push(root);
        root = root->left;
      } else {
        TreeNode* top = s.top();
        if (top->right && top->right != last) {
          root = top->right;
        } else {
          res.push_back(top->val);
          last = top;
          s.pop();
        }
      }
    }
    return res;
  }
};
