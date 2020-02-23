
// Definition for singly-linked list.
struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
 public:
  ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
    if (!l1 || !l2) {
      return l1 ? l1 : l2;
    }
    ListNode dummy(0);
    ListNode *p = &dummy;
    int carry = 0;
    while (l1 || l2 || carry) {
      carry += l1 ? l1->val : 0;
      carry += l2 ? l2->val : 0;
      p->next = new ListNode(carry % 10);
      p = p->next;
      carry /= 10;
      l1 = l1 ? l1->next : l1;
      l2 = l2 ? l2->next : l2;
    }
    return dummy.next;
  }
};
