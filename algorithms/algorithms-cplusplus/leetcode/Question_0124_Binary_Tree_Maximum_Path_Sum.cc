#include <limits.h>
#include <algorithm>

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
  int maxPathSum(TreeNode* root) {
    int res = INT_MIN;
    help(root, res);
    return res;
  }

  int help(TreeNode* root, int& res) {
    if (!root) {
      return 0;
    }
    int left = max(help(root->left, res), 0);
    int right = max(help(root->right, res), 0);
    res = max(res, left + right + root->val);
    return max(left, right) + root->val;
  }
};
