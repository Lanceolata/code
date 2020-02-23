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
  vector<int> printListFromTailToHead(ListNode* head) {      
    vector<int> res;
    help(head, res);
    return res;
  }

  void help(ListNode* head, vector<int>& res) {
    if (!head) {
      return;
    }
    help(head->next, res);
    res.push_back(head->val);
  }
};
