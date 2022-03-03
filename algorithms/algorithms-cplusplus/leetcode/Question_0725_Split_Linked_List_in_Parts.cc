#include <vector>

using namespace std;

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
  vector<ListNode*> splitListToParts(ListNode* head, int k) {
    vector<ListNode*> res;
    ListNode *p = head;
    int cnt = 0;
    while (p) {
      cnt++;
      p = p->next;
    }
    int width = cnt / k, rem = cnt % k;
    for (int i = 0; i < k; i++) {
      p = head;
      for (int j = 0; j < width + (i < rem ? 1 : 0) - 1; j++) {
        if (p) {
          p = p->next;
        }
      }
      res.push_back(head);
      if (p != null) {
        head = p->next;
        p->next = nullptr;
      }
    }
    return res;
  }
};
