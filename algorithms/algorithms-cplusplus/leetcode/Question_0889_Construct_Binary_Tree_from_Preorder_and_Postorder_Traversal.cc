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
  TreeNode* constructFromPrePost(vector<int>& preorder, vector<int>& postorder) {
    int preIndex = 0, posIndex = 0;
    return help(preorder, preIndex, postorder, posIndex);
  }

 private:
  TreeNode* help(vector<int>& preorder, int& preIndex, vector<int>& postorder, int& posIndex) {
    TreeNode* root = new TreeNode(preorder[preIndex++]);
    if (root->val != postorder[posIndex]) {
      root->left = help(preorder, preIndex, postorder, posIndex);
    }
    if (root->val != postorder[posIndex]) {
      root->right = help(preorder, preIndex, postorder, posIndex);
    }
    posIndex++;
    return root;
  }
};
