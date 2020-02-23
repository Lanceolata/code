
// Definition for singly-linked list.
struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
 public:
  ListNode* oddEvenList(ListNode* head) {
    ListNode dummy1(0), dummy2(0);
    ListNode *p1 = &dummy1, *p2 = &dummy2;
    int cnt = 0;
    while (head) {
      if ((cnt & 1) == 0) {
        p1->next = head;
        p1 = p1->next;
      } else {
        p2->next = head;
        p2 = p2->next;
      }
      cnt++;
      head = head->next;
    }
    p2->next = NULL;
    p1->next = dummy2.next;
    return dummy1.next;
  }
};