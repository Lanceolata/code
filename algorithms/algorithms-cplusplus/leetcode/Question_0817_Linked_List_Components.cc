#include <vector>
#include <unordered_set>

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
  int numComponents(ListNode* head, vector<int>& nums) {
    unordered_set<int> s (nums.begin(), nums.end());
    int res = 0;
    while (head) {
      if (s.count(head->val) && (!head->next || !s.count(head->next->val))) {
        res++;
      }
      head = head->next;
    }
    return res;
  }
};
