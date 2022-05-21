#include <string>

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
  string smallestFromLeaf(TreeNode* root) {
    string res;
    dfs(root, "", res);
    return res;
  }

 private:
  void dfs(TreeNode* root, string s, string& res) {
    if (!root) {
      return;
    }
    s = char(root->val + 'a') + s;
    if (!root->left && !root->right){
      res = res == "" ? s : min(res, s);
    }
    dfs(root->left, s, res);
    dfs(root->right, s, res);
  }
};
