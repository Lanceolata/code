#ifndef ALGORITHM_BASICS_BINARY_TREE_TRAVERSAL_H_
#define ALGORITHM_BASICS_BINARY_TREE_TRAVERSAL_H_

#include <stdio.h>
#include <vector>

using namespace std;

// Definition for a binary tree node.
struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Traversal {
 public:
  virtual ~Traversal() {}

  virtual vector<int> traversal_recursive(TreeNode *root) = 0;

  virtual vector<int> traversal(TreeNode *root) = 0;
};

#endif  // ALGORITHM_BASICS_BINARY_TREE_TRAVERSAL_H_
