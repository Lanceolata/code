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
  bool isBalanced(TreeNode* root) {
    return help(root) >= 0;
  }

  int help(TreeNode* root) {
    if (!root) {
      return 0;
    }
    int left = help(root->left);
    int right = help(root->right);
    if (left < 0 || right < 0 || left - right < -1 || left - right > 1) {
      return -1;
    }
    return max(left, right) + 1;
  }
};
