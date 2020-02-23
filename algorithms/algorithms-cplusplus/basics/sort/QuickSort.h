#include "Sort.h"

template<class T>
class QuickSort : public Sort<T> {
 public:
  void sort(vector<T>& vec) {
    int n = vec.size() - 1;
    sort(vec, 0, n);
  }

 private:
  void sort(vector<T>& vec, int l, int h) {
    if (l >= h) {
      return;
    }
    int m = partition(vec, l, h);
    sort(vec, l, m);
    sort(vec, m + 1, h);
  }

  int partition(vector<T>& vec, int l, int h) {
    int i = l, j = h;
    T v = vec[l];
    while (i < j) {
      while (i < j && vec[j] >= v) {
        j--;
      }
      while (i < j && vec[i] <= v) {
        i++;
      }
      if (i < j) {
        swap(vec[i++], vec[j--]);
      }
    }
    swap(vec[l], vec[i]);
    return i;
  }
};
