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
  vector<string> binaryTreePaths(TreeNode* root) {
    vector<string> paths;
    if (root) {
      dfs(root, "", paths);
    }
    return paths;
  }

  void dfs(TreeNode* root, string path, vector<string>& paths) {
    if (!root->left && !root->right) {
      paths.push_back(path + to_string(root->val));
    }
    if (root->left) {
      dfs(root->left, path + to_string(root->val) + "->", paths);
    }
    if (root->right) {
      dfs(root->right, path + to_string(root->val) + "->", paths);
    }
  }
};
