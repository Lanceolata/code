#include <vector>
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
  vector<int> largestValues(TreeNode* root) {
    vector<int> res;
    if (!root) {
      return res;
    }
    queue<TreeNode*> q;
    q.push(root);
    while (!q.empty()) {
      int m = q.front()->val, size = q.size();
      for (int i = 0; i < size; i++) {
        TreeNode* n = q.front();
        q.pop();
        m = max(m, n->val);
        if (n->left) {
          q.push(n->left);
        }
        if (n->right) {
          q.push(n->right);
        }
      }
      res.push_back(m);
    }
    return res;
  }
};
