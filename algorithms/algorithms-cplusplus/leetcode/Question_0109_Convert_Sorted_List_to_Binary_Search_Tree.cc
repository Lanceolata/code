
// Definition for singly-linked list.
struct ListNode {
  int val;
  ListNode *next;
  ListNode() : val(0), next(nullptr) {}
  ListNode(int x) : val(x), next(nullptr) {}
  ListNode(int x, ListNode *next) : val(x), next(next) {}
};

// Definition for a binary tree node.
struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode() : val(0), left(nullptr), right(nullptr) {}
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
  TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
 public:
  ListNode* curHead = nullptr;
  TreeNode* sortedListToBST(ListNode* head) {
    if (!head) {
      return nullptr;
    }
    curHead = head;
    int len = 0;
    while (head) {
      len++;
      head = head->next;
    }
    return buildTree(0, len - 1);
  }

  TreeNode* buildTree(int start, int end) {
    if (start > end) {
      return nullptr;
    }
    int mid = start + (end - start)/2;
    TreeNode* left = buildTree(start, mid - 1);
    TreeNode* root = new TreeNode(curHead->val);
    root->left = left;
    curHead = curHead->next;
    root->right = buildTree(mid + 1, end);
    return root;
  }
};
