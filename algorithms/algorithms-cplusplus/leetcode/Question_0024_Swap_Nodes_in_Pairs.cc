
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
  ListNode* swapPairs(ListNode* head) {
    ListNode dummy(0);
    dummy.next = head;
    ListNode *p = &dummy, *next;
    while (p->next && p->next->next) {
      next = p->next->next;
      p->next->next = next->next;
      next->next = p->next;
      p->next = next;
      p = p->next->next;
    }
    return dummy.next;
  }
};
