#include <vector>

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
  vector<vector<int>> pathSum(TreeNode* root, int sum) {
    vector<vector<int>> res;
    vector<int> vec;
    if (!root) {
      return res;
    }
    help(root, sum, vec, res);
    return res;
  }

  void help(TreeNode* root, int sum, vector<int>& vec, vector<vector<int>>& res) {
    if (!root) {
      return;
    }
    vec.push_back(root->val);
    if (!root->left && !root->right && root->val == sum) {
      res.push_back(vec);
    } else {
      help(root->left, sum - root->val, vec, res);
      help(root->right, sum - root->val, vec, res);
    }
    vec.pop_back();
  }
};
