
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
  ListNode* deleteDuplicates(ListNode* head) {
    ListNode dummy(0);
    dummy.next = head;
    ListNode *p = &dummy;
    while (p->next) {
      head = p->next;
      while (head->next && head->val == head->next->val) {
        head = head->next;
      }
      if (head == p->next) {
        p = p->next;
      } else {
        p->next = head->next;
      }
    }
    return dummy.next;
  }
};
