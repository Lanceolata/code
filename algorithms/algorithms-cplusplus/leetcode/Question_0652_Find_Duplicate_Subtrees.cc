#include <string>
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
  vector<TreeNode*> findDuplicateSubtrees(TreeNode* root) {
    vector<TreeNode*> res;
    if (!root) {
      return res;
    }
    unordered_map<string, vector<TreeNode*>> map;
    serialize(root, map);
    for (auto it = map.begin(); it != map.end(); it++) {
      if (it->second.size() > 1) {
        res.push_back(it->second[0]);
      }
    }
    return res;
  }

 private:
  string serialize(TreeNode* root, unordered_map<string, vector<TreeNode*>>& map) {
    if (!root) {
      return "";
    }
    string s = to_string(root->val) + "(" + serialize(root->left, map) + "," + serialize(root->right, map) + ")";
    map[s].push_back(root);
    return s;
  }
};
