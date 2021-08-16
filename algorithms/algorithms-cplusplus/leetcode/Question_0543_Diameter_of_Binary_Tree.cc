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
  int diameterOfBinaryTree(TreeNode* root) {
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
    res = max(res, left + right);
    return max(left, right) + 1;
  }
};
