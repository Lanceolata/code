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
  TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
    return help(preorder, 0, preorder.size() - 1, inorder, 0, inorder.size() - 1);
  }

  TreeNode* help(vector<int>& preorder, int preStart, int preEnd, vector<int>& inorder, int inStart, int inEnd) {
    if (preStart > preEnd || inStart > inEnd) {
      return nullptr;
    }
    int rootVal = preorder[preStart];
    int i = inStart;
    for (; i <= inEnd; i++) {
      if (inorder[i] == rootVal) {
        break;
      }
    }
    int len = i - inStart;
    TreeNode* root = new TreeNode(rootVal);
    root->left = help(preorder, preStart + 1, preStart + len, inorder, inStart, i - 1);
    root->right = help(preorder, preStart + len + 1, preEnd, inorder, i + 1, inEnd);
    return root;
  }
};
