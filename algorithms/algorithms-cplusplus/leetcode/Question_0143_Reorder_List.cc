
// Definition for singly-linked list.
struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
 public:
  void reorderList(ListNode* head) {
    if (!head || !head->next) return;

    ListNode *slow = head, *fast = head;
    while (fast->next && fast->next->next) {
      slow = slow->next;
      fast = fast->next->next;
    }
    fast = reverse(slow->next);
    slow->next = NULL;
    merge(head, fast);
  }

  ListNode* reverse(ListNode* head) {
    ListNode *pre = NULL, *next = NULL;
    while (head) {
      next = head->next;
      head->next = pre;
      pre = head;
      head = next;
    }
    return pre;
  }

  void merge(ListNode* head1, ListNode* head2) {
    ListNode* next;
    while (head1 && head2) {
      next = head1->next;
      head1->next = head2;
      head1 = next;
      next = head2->next;
      head2->next = head1;
      head2 = next;
    }
  }
};
