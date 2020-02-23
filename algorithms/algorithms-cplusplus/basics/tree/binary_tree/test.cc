#include "Traversal.h"
#include "PreorderTraversal.h"
#include "InorderTraversal.h"
#include "PostorderTraversal.h"

#include <iostream>
#include <string>

void printVector(vector<int>& vec) {
  for (int i : vec) {
    std::cout << i << " ";
  }
  std::cout << std::endl;
}

void test(string s, Traversal *t) {
  TreeNode *t1 = new TreeNode(1);
  TreeNode *t2 = new TreeNode(2);
  TreeNode *t3 = new TreeNode(3);
  TreeNode *t4 = new TreeNode(4);
  TreeNode *t5 = new TreeNode(5);
  TreeNode *t6 = new TreeNode(6);
  t4->left = t2;
  t4->right = t6;
  t2->left = t1;
  t2->right = t3;
  t6->left = t5;

  std::cout << "test " << s << std::endl;
  std::cout << "-----------------------------" << std::endl;

  vector<int> res = t->traversal_recursive(t4);
  printVector(res);
  res = t->traversal(t4);
  printVector(res);

  std::cout << "-----------------------------" << std::endl;
}

int main() {
  Traversal *t = new PreorderTraversal();
  test("PreorderTraversal", t);
  t = new InorderTraversal();
  test("InorderTraversal", t);
  t = new PostorderTraversal();
  test("PostorderTraversal", t);
}
