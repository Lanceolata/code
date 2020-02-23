#include "Sort.h"

template<class T>
class HeapSort : public Sort<T> {
 public:
  void sort(vector<T>& vec) {
    int n = vec.size() - 1;
    for (int i = n / 2 - 1; i >= 0; i--) {
      sink(vec, i, n);
    }
    while (n > 0) {
      swap(vec[0], vec[n--]);
      sink(vec, 0, n);
    }
  }

 private:
  void sink(vector<T>& vec, int k, int n) {
    int i = 0;
    while (k * 2 + 1 <= n) {
      i = k * 2 + 1;
      if (i < n && vec[i] < vec[i + 1]) {
        i++;
      }
      if (vec[k] >= vec[i]) {
        break;
      }
      swap(vec[k], vec[i]);
      k = i;
    }
  }
};
