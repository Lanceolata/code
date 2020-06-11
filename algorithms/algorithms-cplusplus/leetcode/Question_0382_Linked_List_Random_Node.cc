#include <stdlib.h>

// Definition for singly-linked list.
struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
 public:
  /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
  Solution(ListNode* head) {
    len = 0;
    ListNode *cur = head;
    this->head = head;
    while (cur) {
      ++len;
      cur = cur->next;
    }
  }
    
  /** Returns a random node's value. */
  int getRandom() {
    int t = rand() % len;
    ListNode *cur = head;
    while (t) {
      --t;
      cur = cur->next;
    }
    return cur->val;
  }

 private:
  int len;
  ListNode *head;
};

class Solution2 {
 public:
  /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
  Solution2(ListNode* head) {
    this->head = head;
  }
    
  /** Returns a random node's value. */
  int getRandom() {
    int res = head->val, i = 2;
    ListNode *cur = head->next;
    while (cur) {
      int j = rand() % i;
      if (j == 0) res = cur->val;
        ++i;
        cur = cur->next;
      }
    return res;
  }

 private:
  ListNode *head;
};
