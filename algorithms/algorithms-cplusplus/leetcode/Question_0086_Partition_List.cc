
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
  ListNode* partition(ListNode* head, int x) {
    ListNode dummy1(0), dummy2(0);
    ListNode *p1 = &dummy1, *p2 = &dummy2;
    while (head) {
      ListNode *next = head->next;
      if (head->val < x) {
        p1->next = head;
        p1 = p1->next;
      } else {
        p2->next = head;
        p2 = p2->next;
      }
      head = next;
    }
    p1->next = dummy2.next;
    p2->next = nullptr;
    return dummy1.next;
  }
};
