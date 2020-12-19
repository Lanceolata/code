#include <vector>
#include <stack>

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
  vector<int> inorderTraversal(TreeNode* root) {
    vector<int> res;
    stack<TreeNode*> s;
    TreeNode* p = root;
    while (!s.empty() || p) {
      if (p) {
        s.push(p);
        p = p->left;
      } else {
        TreeNode *t = s.top();
        s.pop();
        res.push_back(t->val);
        p = t->right;
      }
    }
    return res;
  }
};
