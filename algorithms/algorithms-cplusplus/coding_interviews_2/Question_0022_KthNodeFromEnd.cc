
// Definition for singly-linked list.
struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
 public:
  ListNode* FindKthToTail(ListNode* pListHead, unsigned int k) {
    if (k <= 0) {
      return NULL;
    }
    ListNode *p = pListHead;
    while (p && k > 0) {
      // 由于是unsigned int，在while条件中判断会出错
      k--;
      p = p->next;
    }
    if (k > 0) {
      return NULL;
    }
    while (p) {
      pListHead = pListHead->next;
      p = p->next;
    }
    return pListHead;
  }
};
