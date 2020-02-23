#include <vector>
#include <queue>

using namespace std;

// Definition for a Node.
class Node {
 public:
  int val;
  vector<Node*> children;
  
  Node() {}

  Node(int _val) {
    val = _val;
  }

  Node(int _val, vector<Node*> _children) {
    val = _val;
    children = _children;
  }
};

class Solution {
 public:
  vector<vector<int>> levelOrder(Node* root) {
    vector<vector<int>> res;
    if (!root) {
      return res;
    }
    queue<Node*> q;
    q.push(root);
    while (!q.empty()) {
      int size = q.size();
      vector<int> vec;
      for (int i = 0; i < size; i++) {
        root = q.front();
        q.pop();
        vec.push_back(root->val);
        for (Node* n : root->children) {
          q.push(n);
        }
      }
      res.push_back(vec);
    }
    return res;
  }
};
