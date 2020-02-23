
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;

    Node() {}

    Node(int _val, Node* _next, Node* _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};

class Solution {
 public:
  Node *copyRandomList(Node *head) {
    if (!head) {
      return head;
    }
    Node *p = head;
    while (p) {
      Node *node = new Node(p->val, NULL, NULL);
      node->next = p->next;
      p->next = node;
      p = p->next->next;
    }
    p = head;
    while (p) {
      if (p->random) {
        p->next->random = p->random->next;
      }
      p = p->next->next;
    }
    p = head;
    Node *newHead = p->next, *next = NULL;
    while (p) {
      next = p->next;
      p->next = next->next;
      if (next->next) {
        next->next = next->next->next;
      }
      p = p->next;
    }
    return newHead;
  }
};
