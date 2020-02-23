
// Definition for singly-linked list.
struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
 public:
  void DeleteNode(ListNode** pListHead, ListNode* pToBeDeleted) {
    if (!pListHead || !pToBeDeleted) {
      return;
    }
    // 要删除的结点不是尾结点
    if (pToBeDeleted->next) {
      ListNode* next = pToBeDeleted->next;
      pToBeDeleted->val = pToBeDeleted->next->val;
      pToBeDeleted->next = pToBeDeleted->next->next;
      delete next;
      next = nullptr;
    }
    // 链表只有一个结点，删除头结点（也是尾结点）
    else if (*pListHead == pToBeDeleted) {
      delete pToBeDeleted;
      pToBeDeleted = nullptr;
      *pListHead = nullptr;
    }
    // 链表中有多个结点，删除尾结点
    else {
      ListNode *node = *pListHead;
      while (node && node->next != pToBeDeleted) {
        node = node->next;
      }
      if (node) {
        node->next = nullptr;
        delete pToBeDeleted;
        pToBeDeleted = nullptr;
      }
    }
  }
};
