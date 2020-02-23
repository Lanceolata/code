
struct TreeLinkNode {
  int val;
  struct TreeLinkNode *left;
  struct TreeLinkNode *right;
  struct TreeLinkNode *next;
  TreeLinkNode(int x) :val(x), left(NULL), right(NULL), next(NULL) {
  }
};

class Solution {
 public:
  TreeLinkNode* GetNext(TreeLinkNode* pNode) {
    if (!pNode) {
      return pNode;
    }
    TreeLinkNode* res = NULL;
    if (pNode->right) {
      res = pNode->right;
      while (res->left) {
        res = res->left;
      }
    } else {
      res = pNode->next;
      while (res && res->right == pNode) {
        pNode = res;
        res = pNode->next;
      }
    }
    return res;
  }
};
