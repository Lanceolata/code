#include <queue>
#include <stack>

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
  int maxDepth(TreeNode* root) {
    return root ? max(maxDepth(root->left), maxDepth(root->right)) + 1 : 0;
  }

  // BFS
  int maxDepth_bfs(TreeNode* root) {
    if (!root) {
      return 0;
    }
    queue<TreeNode*> q;
    q.push(root);
    int deep = 0;
    while (!q.empty()) {
      size_t size = q.size();
      while (size-- > 0) {
        TreeNode* node = q.front();
        q.pop();
        if (node->left) {
          q.push(node->left);
        }
        if (node->right) {
          q.push(node->right);
        }
      }
      deep++;
    }
    return deep;
  }
};