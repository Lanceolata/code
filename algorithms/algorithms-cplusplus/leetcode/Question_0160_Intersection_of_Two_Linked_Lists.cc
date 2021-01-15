
// Definition for singly-linked list.
struct ListNode {
  int val;
  ListNode *next;
  ListNode() : val(0), next(nullptr) {}
  ListNode(int x) : val(x), next(nullptr) {}
  ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
 public:
  ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
    if (!headA || !headB) {
      return nullptr;
    }
    ListNode *a = headA, *b = headB;
    while (a != b) {
      a = !a ? headB : a->next;
      b = !b ? headA : b->next;
    }
    return a;
  }
};
