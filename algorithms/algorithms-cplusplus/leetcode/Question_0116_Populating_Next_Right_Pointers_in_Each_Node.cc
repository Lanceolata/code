
// Definition for a Node.
class Node {
 public:
  int val;
  Node* left;
  Node* right;
  Node* next;

  Node() {}

  Node(int _val, Node* _left, Node* _right, Node* _next) {
    val = _val;
    left = _left;
    right = _right;
    next = _next;
  }
};

class Solution {
 public:
  Node* connect(Node* root) {
    if (!root) {
      return root;
    }
    Node *cur = root, *p;
    while (cur->left) {
      p = cur;
      while (p) {
        p->left->next = p->right;
        if (p->next) {
          p->right->next = p->next->left;
        }
        p = p->next;
      }
      cur = cur->left;
    }
    return root;
  }
};