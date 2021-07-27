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
  vector<int> findMode(TreeNode* root) {
    vector<int> res;
    if (!root) {
      return res;
    }
    stack<TreeNode*> st;
    TreeNode* pre = nullptr;
    int cnt = 1, mx = 0;
    while (root || !st.empty()) {
      if (root) {
        st.push(root);
        root = root->left;
      } else {
        root = st.top();
        st.pop();
        if (pre) {
          cnt = (pre->val == root->val) ? cnt + 1 : 1;
        }
        if (cnt >= mx) {
          if (cnt > mx) {
            res.clear();
          }
          res.push_back(root->val);
          mx = cnt;
        }
        pre = root;
        root = root->right;
      }
    }
    return res;
  }
};
