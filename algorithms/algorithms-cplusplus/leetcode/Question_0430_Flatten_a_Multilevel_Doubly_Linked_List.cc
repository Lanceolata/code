
// Definition for a Node.
class Node {
 public:
  int val;
  Node* prev;
  Node* next;
  Node* child;

  Node() {}

  Node(int _val, Node* _prev, Node* _next, Node* _child) {
    val = _val;
    prev = _prev;
    next = _next;
    child = _child;
  }
};

class Solution {
 public:
  Node* flatten(Node* head) {
    Node *p = head;
    while (p) {
      if (!p->child) {
        p = p->next;
        continue;
      }
      Node * t = p->child;
      while (t->next) {
        t = t->next;
      }
      t->next = p->next;
      if (p->next) {
        p->next->prev = t;
      }
      p->next = p->child;
      p->child->prev = p;
      p->child = NULL;
    }
    return head;
  }
};
