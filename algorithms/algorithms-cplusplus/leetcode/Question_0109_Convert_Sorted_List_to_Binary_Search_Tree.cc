
// Definition for singly-linked list.
struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(NULL) {}
};

// Definition for a binary tree node.
struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
 public:
  ListNode* curHead = NULL;
  TreeNode* sortedListToBST(ListNode* head) {
    if (!head) {
      return NULL;
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
      return NULL;
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
