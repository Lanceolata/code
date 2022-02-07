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
  TreeNode* constructMaximumBinaryTree(vector<int>& nums) {
    if (nums.empty()) {
      return nullptr;
    }
    return help(nums, 0, nums.size() - 1);
  }

  TreeNode* help(vector<int>& nums, int start, int end) {
    if (start > end) {
      return nullptr;
    }
    if (start == end) {
      return new TreeNode(nums[start]);
    }
    int i = start;
    for (int j = start; j <= end; j++) {
      if (nums[j] > nums[i]) {
        i = j;
      }
    }
    TreeNode* root = new TreeNode(nums[i]);
    root->left = help(nums, start, i - 1);
    root->right = help(nums, i + 1, end);
    return root;
  }
};
