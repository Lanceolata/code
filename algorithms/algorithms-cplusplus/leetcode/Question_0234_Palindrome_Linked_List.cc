
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
    slow->next = nullptr;
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
    ListNode* pre = nullptr, *next = nullptr;
    while (head) {
      next = head->next;
      head->next = pre;
      pre = head;
      head = next;
    }
    return pre;
  }
};
