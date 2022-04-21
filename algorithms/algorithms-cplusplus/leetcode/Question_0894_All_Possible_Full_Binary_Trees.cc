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
  vector<TreeNode*> allPossibleFBT(int n) {
    unordered_map<int, vector<TreeNode*>> m;
    return help(n, m);
  }

 private:
  vector<TreeNode*> help(int n, unordered_map<int, vector<TreeNode*>>& m) {
    if (m.count(n)) {
      return m[n];
    }
    vector<TreeNode*> res;
    if (n == 1) {
      res.push_back(new TreeNode(0));
    } else if (n % 2 == 1) {
      for (int i = 0; i < n; i++) {
        int j = n - 1 - i;
        for (TreeNode* left : help(i, m)) {
          for (TreeNode* right : help(j, m)) {
            res.push_back(new TreeNode(0, left, right));
          }
        }
      }
    }
    m[n] = res;
    return res;
  }
};
