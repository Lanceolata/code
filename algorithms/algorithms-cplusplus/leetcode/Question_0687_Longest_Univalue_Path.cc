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
  int longestUnivaluePath(TreeNode* root) {
    int res = 0;
    help(root, res);
    return res;
  }

  int help(TreeNode* root, int& res) {
    if (!root) {
      return 0;
    }
    int left = help(root->left, res);
    int right = help(root->right, res);
    int l = 0, r = 0;
    if (root->left && root->left->val == root->val) {
      l += left + 1;
    }
    if (root->right && root->right->val == root->val) {
      r += right + 1;
    }
    res = max(res, l + r);
    return max(l, r);
  }
};
