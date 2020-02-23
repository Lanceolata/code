#include "Sort.h"
#include "BubbleSort.h"
#include "InsertionSort.h"
#include "MergeSort.h"
#include "HeapSort.h"
#include "SelectionSort.h"
#include "ShellSort.h"
#include "QuickSort.h"
#include "ThreeWayQuickSort.h"

#include <string>
#include <iostream>

void printVector(vector<int>& vec) {
  for (int i : vec) {
    std::cout << i << " ";
  }
  std::cout << std::endl;
}

void test(Sort<int>* sort, vector<int>& vec) {
  std::cout << "-----------------------------" << std::endl;
  std::cout << "input:" << std::endl;
  printVector(vec);
  sort->sort(vec);
  std::cout << "output:" << std::endl;
  printVector(vec);
}

void test(string s, Sort<int>* sort) {
  std::cout << "test " << s << std::endl;
  vector<int> vec = {9,8,7,6,5,4,3,2,1};
  test(sort, vec);
  vec = {1,2,3,4,5,6,7,9,8};
  test(sort, vec);
  std::cout << "-----------------------------" << std::endl;
}

int main() {
  Sort<int> *sort = nullptr;
  sort = new BubbleSort<int>();
  test("BubbleSort", sort);
  sort = new InsertionSort<int>();
  test("InsertionSort", sort);
  sort = new MergeSort<int>();
  test("MergeSort", sort);
  sort = new HeapSort<int>();
  test("HeapSort", sort);
  sort = new SelectionSort<int>();
  test("SelectionSort", sort);
  sort = new ShellSort<int>();
  test("ShellSort", sort);
  sort = new QuickSort<int>();
  test("QuickSort", sort);
  sort = new ThreeWayQuickSort<int>();
  test("ThreeWayQuickSort", sort);
}
