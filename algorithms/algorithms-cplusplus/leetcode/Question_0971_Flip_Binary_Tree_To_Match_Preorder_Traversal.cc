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
  vector<int> flipMatchVoyage(TreeNode* root, vector<int>& voyage) {
    int i = 0;
    vector<int> res;
    if (!help(root, voyage, i, res) || i != voyage.size()) {
      return {-1};
    }
    return res;
  }

 private:
  bool help(TreeNode* root, vector<int>& voyage, int& i, vector<int>& res) {
    if (!root) {
      return true;
    }
    if (root->val != voyage[i++]) {
      return false;
    }
    if (root->left && root->left->val != voyage[i]) {
      res.push_back(root->val);
      return help(root->right, voyage, i, res) && help(root->left, voyage, i, res);
    }
    return help(root->left, voyage, i, res) && help(root->right, voyage, i, res);
  }
};
