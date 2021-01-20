
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
  void deleteNode(ListNode* node) {
    if (!node || !node->next) {
      return;
    }
    node->val = node->next->val;
    node->next = node->next->next;
  }
};
