
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
  ListNode* sortList(ListNode* head) {
    if (!head || !head->next) {
      return head;
    }
    ListNode *slow = head, *fast = head;
    while (fast->next && fast->next->next) {
      slow = slow->next;
      fast = fast->next->next;
    }
    fast = slow->next;
    slow->next = nullptr;
    return merge(sortList(head), sortList(fast));
  }

  ListNode* merge(ListNode* l1, ListNode* l2) {
    ListNode dummy(0);
    ListNode* p = &dummy;
    while (l1 && l2) {
      if (l1->val < l2->val) {
        p->next = l1;
        l1 = l1->next;
      } else {
        p->next = l2;
        l2 = l2->next;
      }
      p = p->next;
    }
    p->next = l1 ? l1 : l2;
    return dummy.next;
  }
};
