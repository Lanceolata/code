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
  vector<int> distanceK(TreeNode* root, TreeNode* target, int k) {
    vector<int> res;
    dfs(root, target, k, res);
    return res;
  }

 private:
  int dfs(TreeNode* root, TreeNode* target, int k, vector<int>& res) {
    if (!root) {
      return -1;
    } else if (root == target) {
      subtree_add(root, k, 0, res);
      return 1;
    } else {
      int l = dfs(root->left, target, k ,res), r = dfs(root->right, target, k ,res);
      if (l != -1) {
        if (l == k) {
          res.push_back(root->val);
        }
        subtree_add(root->right, k, l + 1, res);
        return l + 1;
      } else if ( r != -1) {
        if (r == k) {
          res.push_back(root->val);
        }
        subtree_add(root->left, k, r + 1, res);
        return r + 1;
      } else {
        return -1;
      }
    }
  }

  void subtree_add(TreeNode* root, int k, int d, vector<int>& res) {
    if (!root) {
      return;
    }
    if (d == k) {
      res.push_back(root->val);
    } else {
      subtree_add(root->left, k, d + 1, res);
      subtree_add(root->right, k, d + 1, res);
    }
  }
};
