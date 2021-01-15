
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
  ListNode* reverseKGroup(ListNode* head, int k) {
    if (!head || k <= 1) {
      return head;
    }
    ListNode dummy(0);
    dummy.next = head;
    int count = 0;
    ListNode *pre = &dummy, *cur = head;
    while (cur) {
      count++;
      if (count % k == 0) {
        pre = reverse(pre, cur->next);
        cur = pre->next;
      } else {
        cur = cur->next;
      }
    }
    return dummy.next;
  }

  ListNode* reverse(ListNode* pre, ListNode* next) {
    ListNode *last = pre->next, *cur = pre->next->next;
    while (cur != next) {
      last->next = cur->next;
      cur->next = pre->next;
      pre->next = cur;
      cur = last->next;
    }
    return last;
  }
};
