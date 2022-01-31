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
  vector<double> averageOfLevels(TreeNode* root) {
    vector<double> res;
    if (!root) {
      return res;
    }
    queue<TreeNode*> q;
    q.push(root);
    while (!q.empty()) {
      long long size = q.size(), sum = 0;
      for (int i = 0; i < size; i++) {
        root = q.front();
        sum += root->val;
        q.pop();
        if (root->left) {
          q.push(root->left);
        }
        if (root->right) {
          q.push(root->right);
        }
      }
      res.push_back(sum * 1.0 / size);
    }
    return res;
  }
};
