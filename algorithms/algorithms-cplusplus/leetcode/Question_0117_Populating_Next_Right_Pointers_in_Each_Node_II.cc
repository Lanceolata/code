
// Definition for a Node.
class Node {
 public:
  int val;
  Node* left;
  Node* right;
  Node* next;

  Node() : val(0), left(NULL), right(NULL), next(NULL) {}

  Node(int _val) : val(_val), left(NULL), right(NULL), next(NULL) {}

  Node(int _val, Node* _left, Node* _right, Node* _next)
    : val(_val), left(_left), right(_right), next(_next) {}
};

class Solution {
 public:
  Node* connect(Node* root) {
    Node dummy(0, NULL, NULL, NULL);
    Node *cur = root, *p = &dummy;
    while (cur) {
      if (cur->left) {
        p->next = cur->left;
        p = p->next;
      }
      if (cur->right) {
        p->next = cur->right;
        p = p->next;
      }
      cur = cur->next;
      if (!cur) {
        p = &dummy;
        cur = p->next;
        p->next = NULL;
      }
    }
    return root;
  }
};
