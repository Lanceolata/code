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
  bool leafSimilar(TreeNode* root1, TreeNode* root2) {
    vector<int> vec1, vec2;
    getLeafs(root1, vec1);
    getLeafs(root2, vec2);
    return vec1 == vec2;
  }

 private:
  void getLeafs(TreeNode* root, vector<int>& res) {
    if (!root) {
      return;
    }
    if (!root->left && !root->right) {
      res.push_back(root->val);
      return;
    }
    getLeafs(root->left, res);
    getLeafs(root->right, res);
  }
};
