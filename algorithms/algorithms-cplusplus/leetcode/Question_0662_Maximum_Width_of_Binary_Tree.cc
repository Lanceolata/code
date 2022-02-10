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
  int widthOfBinaryTree(TreeNode* root) {
    vector<pair<unsigned long long, unsigned long long>> vec;
    return (int) dfs(root, 0, 1, vec);
  }

  unsigned long long dfs(TreeNode* root, int level, unsigned long long order, vector<pair<unsigned long long, unsigned long long>>& vec){
    if(!root) {
      return 0;
    }
    if(vec.size() == level) {
      vec.push_back({order, order});
    } else {
      vec[level].second = order;
    }
    unsigned long long cur = vec[level].second - vec[level].first + 1;
    unsigned long long left = dfs(root->left, level + 1, 2 * order, vec);
    unsigned long long right = dfs(root->right, level + 1, 2 * order + 1, vec);
    return max({cur, left, right});
  }
};
