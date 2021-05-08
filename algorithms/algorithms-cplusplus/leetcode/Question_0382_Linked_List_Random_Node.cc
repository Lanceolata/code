#include <stdlib.h>

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
  /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
  Solution(ListNode* head) {
    h = head;
  }
    
  /** Returns a random node's value. */
  int getRandom() {
    int res = h->val, i = 2;
    ListNode *cur = h->next;
    while (cur) {
      int j = rand() % i;
      if (j == 0) {
        res = cur->val;
      }
      ++i;
      cur = cur->next;
    }
    return res;
  }

 private:
  ListNode *h;
};
