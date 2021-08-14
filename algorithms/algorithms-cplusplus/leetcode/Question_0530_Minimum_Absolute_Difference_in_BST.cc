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
  int getMinimumDifference(TreeNode* root) {
    int res = INT_MAX, pre = -1;
    help(root, pre, res);
    return res;
  }

  void help(TreeNode* root, int& pre, int& res) {
    if (!root) {
      return;
    }
    help(root->left, pre, res);
    if (pre != -1) {
      res = min(res, root->val - pre);
    }
    pre = root->val;
    help(root->right, pre, res);
  }
};
