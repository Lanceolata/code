
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
  ListNode* insertionSortList(ListNode* head) {
    if (!head) {
      return head;
    }
    ListNode dummy(0);
    ListNode *pre, *next;
    while (head) {
      next = head->next;
      pre = &dummy;
      while (pre->next && pre->next->val <= head->val) {
        pre = pre->next;
      }
      head->next = pre->next;
      pre->next = head;
      head = next;
    }
    return dummy.next;
  }
};
