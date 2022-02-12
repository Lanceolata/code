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
  int findSecondMinimumValue(TreeNode* root) {
    if (!root) {
      return -1;
    }
    int left = (root->left && root->left->val != root->val) ? root->left->val : findSecondMinimumValue(root->left);
    int right = (root->right && root->right->val != root->val) ? root->right->val : findSecondMinimumValue(root->right);
    if (left == -1 || right == -1) {
      return max(left, right);
    }
    return min(left, right);
  }
};
