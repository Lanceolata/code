
//Definition for singly-linked list.
struct ListNode {
  int val;
  ListNode *next;
  ListNode() : val(0), next(nullptr) {}
  ListNode(int x) : val(x), next(nullptr) {}
  ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
 public:
  ListNode* reverseBetween(ListNode* head, int m, int n) {
    ListNode dummy(0);
    dummy.next = head;
    ListNode *p = &dummy;
    for (int i = 1; i < m; i++) {
      p = p->next;
    }
    ListNode *last = p->next, *cur;
    for (int i = m; i < n; i++) {
      cur = last->next;
      last->next = cur->next;
      cur->next = p->next;
      p->next = cur;
    }
    return dummy.next;
  }
};
