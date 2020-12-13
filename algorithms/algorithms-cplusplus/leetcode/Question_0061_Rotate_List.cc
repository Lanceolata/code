
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
  ListNode* rotateRight(ListNode* head, int k) {
    if (!head || k <= 0) {
      return head;
    }
    int n = 1;
    ListNode *cur = head;
    while (cur->next) {
      cur = cur->next;
      n++;
    }
    cur->next = head;
    n -= k % n;
    while (n--) {
      cur = cur->next;
    }
    head = cur->next;
    cur->next = nullptr;
    return head;
  }
};
