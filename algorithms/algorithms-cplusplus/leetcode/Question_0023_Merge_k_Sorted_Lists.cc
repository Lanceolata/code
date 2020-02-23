#include <vector>

using namespace std;

// Definition for singly-linked list.
struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
 public:
  ListNode* mergeKLists(vector<ListNode*>& lists) {
    if (lists.empty()) {
      return NULL;
    }
    size_t len = lists.size();
    for (size_t i = 1; i < len; i *= 2) {
      for (size_t j = 0; j < len - i; j += 2 * i) {
        lists[j] = merge2Lists(lists[j], lists[j + i]);
      }
    }
    return lists[0];
  }

  ListNode* merge2Lists(ListNode* l1, ListNode* l2) {
    ListNode dummy(0);
    ListNode* p = &dummy;
    while (l1 && l2) {
      if (l1->val < l2->val) {
        p->next = l1;
        l1 = l1->next;
      } else {
        p->next = l2;
        l2 = l2->next;
      }
      p = p->next;
    }
    p->next = l1 ? l1 : l2;
    return dummy.next;
  }
};
