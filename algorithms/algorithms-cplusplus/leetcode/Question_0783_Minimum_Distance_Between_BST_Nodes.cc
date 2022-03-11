#include <limits.h>
#include <algorithm>

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
  int minDiffInBST(TreeNode* root) {
    int res = INT_MAX;
    TreeNode* pre = nullptr;
    help(root, pre, res);
    return res;
  }

 private:
  void help(TreeNode* root, TreeNode*& pre, int& res) {
    if (!root) {
      return;
    }
    help(root->left, pre, res);
    if (pre) {
      res = min(res, root->val - pre->val);
    }
    pre = root;
    help(root->right, pre, res);
  }
};
