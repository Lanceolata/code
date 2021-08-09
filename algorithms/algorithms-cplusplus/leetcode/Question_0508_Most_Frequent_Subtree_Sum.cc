#include <vector>
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
  vector<int> findFrequentTreeSum(TreeNode* root) {
    vector<int> res;
    if (!root) {
      return res;
    }
    unordered_map<int, int> m;
    int cnt = 0;
    postorder(root, m, cnt);
    for (auto a : m) {
      if (a.second == cnt) res.push_back(a.first);
    }
    return res;
  }

  int postorder(TreeNode* node, unordered_map<int, int>& m, int& cnt) {
    if (!node) {
      return 0;
    }
    int left = postorder(node->left, m, cnt);
    int right = postorder(node->right, m, cnt);
    int sum = left + right + node->val;
    cnt = max(cnt, ++m[sum]);
    return sum;
  }
};
