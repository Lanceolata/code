#include <unordered_map>

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
  int pathSum(TreeNode* root, int targetSum) {
    if (!root) { 
      return 0;
    }
    int num = 0;
    unordered_map<long long, long long> num_paths;
    num_paths[0] = 1;
    help(root, targetSum, 0, num, num_paths);
    return num;
  }

  void help(TreeNode* root, int sum, long long cursum, int& num, unordered_map<long long, long long>& num_paths) {
    if (!root) {
      return;
    }
    cursum += root->val;
    if(num_paths.count(cursum - sum)){
      num += num_paths[cursum - sum];
    }
    if(num_paths.count(cursum)){
      num_paths[cursum] += 1;
    } else {
      num_paths[cursum] = 1;
    }
    help(root->left, sum, cursum, num, num_paths);
    help(root->right, sum, cursum, num, num_paths);
    num_paths[cursum] -= 1;
    return;
  }
};
