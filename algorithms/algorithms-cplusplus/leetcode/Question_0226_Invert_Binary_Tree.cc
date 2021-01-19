#include <queue>

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
  TreeNode* invertTreeRecursive(TreeNode* root) {
    if (!root) {
      return nullptr;
    }
    TreeNode* left = invertTree(root->left);
    TreeNode* right = invertTree(root->right);
    root->right = left;
    root->left = right;
    return root;
  }

  TreeNode* invertTree(TreeNode* root) {
    if (!root) {
      return nullptr;
    }
    queue<TreeNode*> q;
    q.push(root);
    while (!q.empty()) {
      TreeNode* cur = q.front();
      q.pop();
      TreeNode* temp = cur->right;
      cur->right = cur->left;
      cur->left = temp;
      if (cur->right) {
        q.push(cur->right);
      }
      if (cur->left) {
        q.push(cur->left);
      }
    }
    return root;
  }
};
