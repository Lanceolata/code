#include <vector>
#include <stack>

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
  vector<int> preorder(Node* root) {
    vector<int> res;
    help(root, res);
    return res;
  }

  void help(Node* root, vector<int>& res) {
    if (!root) {
      return;
    }
    res.push_back(root->val);
    for (Node* p : root->children) {
      help(p, res);
    }
  }

  vector<int> preorder2(Node* root) {
    vector<int> res;
    if (!root) {
      return res;
    }
    stack<Node*> s;
    s.push(root);
    while (!s.empty()) {
      root = s.top();
      s.pop();
      res.push_back(root->val);
      for (int i = root->children.size() - 1; i >= 0; i--) {
        s.push(root->children[i]);
      }
    }
    return res;
  }
};
