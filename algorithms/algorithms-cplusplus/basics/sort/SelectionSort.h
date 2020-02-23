#include "Sort.h"

template<class T>
class SelectionSort : public Sort<T> {
 public:
  void sort(vector<T>& vec) {
    int n = vec.size();
    for (int i = 0; i < n; i++) {
      int index = i;
      for (int j = i + 1; j < n; j++) {
        if (vec[j] < vec[index]) {
          index = j;
        }
      }
      swap(vec[i], vec[index]);
    }
  }
};
