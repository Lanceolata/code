#include <math.h>
#include <vector>
#include <string>

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
  vector<vector<string>> printTree(TreeNode* root) {
    if (!root) {
      return {};
    }
    int height = getHeight(root);
    int m = height, n = pow(2, height) - 1;
    vector<vector<string>> res(m, vector<string>(n, "")); 
    place(root, 0, 0, n - 1, res);
    return res;
  }

  int getHeight(TreeNode* root) {
    return root ? max(getHeight(root->left), getHeight(root->right)) + 1 : 0;
  }

  void place(TreeNode* root, int m, int l, int r, vector<vector<string>>& res) {
    if (!root) {
      return;
    }
    int mid = l + (r - l) / 2;
    res[m][mid] = to_string(root->val);
    place(root->left, m + 1, l, mid - 1, res);
    place(root->right, m + 1, mid + 1, r, res);
  }
};
