
// Definition for singly-linked list.
struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
 public:
  bool isPalindrome(ListNode* head) {
    if (!head) {
      return true;
    }
    ListNode *slow = head, *fast = head;
    while (fast->next && fast->next->next) {
      slow = slow->next;
      fast = fast->next->next;
    }
    fast = slow->next;
    fast = reverse(fast);
    slow->next = NULL;
    while (fast) {
      if (head->val != fast->val) {
        return false;
      }
      head = head->next;
      fast = fast->next;
    }
    return true;
  }

  ListNode* reverse(ListNode* head) {
    ListNode* pre = NULL, *next = NULL;
    while (head) {
      next = head->next;
      head->next = pre;
      pre = head;
      head = next;
    }
    return pre;
  }
};
