#include <vector>

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
  vector<TreeNode*> generateTrees(int n) {
    if (n < 1) {
      return {};
    }
    return helper(1, n);
  }

  vector<TreeNode*> helper(int start, int end) {
    vector<TreeNode *> res;
    if(start > end) {
      res.push_back(NULL);
      return res;
    }
    for(int k = start; k <= end; k++) {
      vector<TreeNode *> left = helper(start, k-1);
      vector<TreeNode *> right = helper(k+1, end);
      for(int i = 0; i < left.size(); i++) {
        for(int j = 0; j< right.size(); j++) {
          TreeNode * root = new TreeNode(k);
          root->left = left[i];
          root->right = right[j];
          res.push_back(root);
        }
      }
    }
    return res;
  }
};
