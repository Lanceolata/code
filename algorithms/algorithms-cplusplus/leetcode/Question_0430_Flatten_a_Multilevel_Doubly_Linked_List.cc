
// Definition for a Node.
class Node {
 public:
  int val;
  Node* prev;
  Node* next;
  Node* child;
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
      p->child = nullptr;
    }
    return head;
  }
};
