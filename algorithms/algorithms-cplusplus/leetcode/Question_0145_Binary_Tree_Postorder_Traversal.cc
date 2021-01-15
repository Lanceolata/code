#include <vector>
#include <stack>

using namespace std;

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
  vector<int> postorderTraversal(TreeNode* root) {
    vector<int> res;
    if (!root) {
      return res;
    }
    stack<TreeNode*> s;
    TreeNode* last = nullptr;
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
