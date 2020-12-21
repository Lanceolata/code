#include <vector>

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
  TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
    return help(inorder, 0, inorder.size() - 1, postorder, 0, postorder.size() - 1);
  }

  TreeNode* help(vector<int>& inorder, int inStart, int inEnd,
      vector<int>& postorder, int postStart, int postEnd) {
    if (inStart > inEnd || postStart > postEnd) {
      return nullptr;
    }
    int rootVal = postorder[postEnd];
    int i = inStart;
    for (; i < inEnd; i++) {
      if (inorder[i] == rootVal) {
        break;
      }
    }
    int len = i - inStart;
    TreeNode* root = new TreeNode(rootVal);
    root->left = help(inorder, inStart, i - 1, postorder, postStart, postStart + len - 1);
    root->right = help(inorder, i + 1, inEnd, postorder, postStart + len, postEnd - 1);
    return root;
  }
};
