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
  int maxAncestorDiff(TreeNode* root) {
    if (!root) {
     return -1;
    }
    int res = 0;
    help(root, root->val, root->val, res);
    return res;
  }

  void help(TreeNode* root, int pmax, int pmin, int& res) {
    if (!root) {
      return;
    }
    res = max(res, abs(root->val - pmax));
    res = max(res, abs(root->val - pmin));
    pmax = max(pmax, root->val);
    pmin = min(pmin, root->val);
    help(root->left, pmax, pmin, res);
    help(root->right, pmax, pmin, res);
  }
};
