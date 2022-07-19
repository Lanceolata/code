
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
  ListNode* reverseBetween(ListNode* head, int left, int right) {
    ListNode dummy(0);
    dummy.next = head;
    ListNode *p = &dummy;
    for (int i = 1; i < left; i++) {
      p = p->next;
    }
    ListNode *last = p->next, *cur;
    for (int i = left; i < right; i++) {
      cur = last->next;
      last->next = cur->next;
      cur->next = p->next;
      p->next = cur;
    }
    return dummy.next;
  }
};
