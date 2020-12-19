#include <vector>
#include <deque>

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
  vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
    vector<vector<int>> res;
    if (!root) {
      return res;
    }
    deque<TreeNode*> dq;
    dq.push_back(root);
    bool flag = true;
    while (!dq.empty()) {
      int size = dq.size();
      vector<int> vec;
      while (size--) {
        if (flag) {
          TreeNode* cur = dq.front();
          dq.pop_front();
          if (cur->left) {
            dq.push_back(cur->left);
          }
          if (cur->right) {
            dq.push_back(cur->right);
          }
          vec.push_back(cur->val);
        } else {
          TreeNode* cur = dq.back();
          dq.pop_back();
          if (cur->right) {
            dq.push_front(cur->right);
          }
          if (cur->left) {
            dq.push_front(cur->left);
          }
          vec.push_back(cur->val);
        }
      }
      res.push_back(vec);
      flag = !flag;
    }
    return res;
  }
};
