#include <vector>

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
  int findBottomLeftValue(TreeNode* root) {
    if (!root) {
      return -1;
    }
    vector<int> res = help(root);
    return res[0];
  }

  vector<int> help(TreeNode* root) {
    if (!root) {
      return {};
    }
    vector<int> left = help(root->left);
    vector<int> right = help(root->right);
    vector<int> res(2, 0);
    res[0] = root->val;
    res[1] = 1;
    if (left.size() > 0) {
      res[0] = left[0];
      res[1] = left[1] + 1;
    }
    if (right.size() > 0 && (left.size() == 0 || left[1] < right[1])) {
      res[0] = right[0];
      res[1] = right[1] + 1;
    }
    return res;
  }
};
