#include <queue>

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
  bool isSymmetric(TreeNode* root) {
    if (!root) {
      return true;
    }
    return help(root->left, root->right);
  }

  bool help(TreeNode* node1, TreeNode* node2) {
    if (!node1 || !node2) {
      return node1 == node2;
    }
    return node1->val == node2->val && help(node1->left, node2->right) && help(node1->right, node2->left);
  }

  bool isSymmetric_bfs(TreeNode* root) {
    std::queue<TreeNode*> q;
    q.push(root);
    q.push(root);
    while (!q.empty()) {
      TreeNode* t1 = q.front();
      q.pop();
      TreeNode* t2 = q.front();
      q.pop();
      
      if (!t1 && !t2) {
        continue;
      }
      if (!t1 || !t2) {
        return false;
      }
      if (t1->val != t2->val) {
        return false;
      }
      q.push(t1->left);
      q.push(t2->right);
      q.push(t1->right);
      q.push(t2->left);
    }
    return true;
  }
};
