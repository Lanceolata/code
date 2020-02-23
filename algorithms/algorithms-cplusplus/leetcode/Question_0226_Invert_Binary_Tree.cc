#include <queue>

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
  TreeNode* invertTreeRecursive(TreeNode* root) {
    if (!root) {
      return NULL;
    }
    TreeNode* left = invertTree(root->left);
    TreeNode* right = invertTree(root->right);
    root->right = left;
    root->left = right;
    return root;
  }

  TreeNode* invertTree(TreeNode* root) {
    if (!root) {
      return NULL;
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
