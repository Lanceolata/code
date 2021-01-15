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
  vector<int> rightSideView(TreeNode* root) {
    vector<int> res;
    if (!root) {
      return res;
    }
    queue<TreeNode*> s;
    s.push(root);
    TreeNode* node;
    while (!s.empty()) {
      int size = s.size();
      while (size--) {
        node = s.front();
        s.pop();
        if (node->left) {
          s.push(node->left);
        }
        if (node->right) {
          s.push(node->right);
        }
        if (size == 0) {
          res.push_back(node->val);
        }
      }
    }
    return res;
  }
};
