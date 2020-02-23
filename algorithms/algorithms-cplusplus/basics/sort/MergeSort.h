#include "Sort.h"

template<class T>
class MergeSort : public Sort<T> {
 public:
  void sort(vector<T>& vec) {
    int n = vec.size() - 1;
    vector<T> copy(vec.size());
    sort(vec, copy, 0, n);
  }

 private:
  void sort(vector<T>& vec, vector<T>& copy, int l, int h) {
    if (l >= h) {
      return;
    }
    int m = l + (h - l) / 2;
    sort(vec, copy, l, m);
    sort(vec, copy, m + 1, h);
    merge(vec, copy, l, m, h);
  }

  void merge(vector<T>& vec, vector<T>& copy, int l, int m, int h) {
    for (int i = l; i <= h; i++) {
      copy[i] = vec[i];
    }
    int i = l, j = m + 1, k = l;
    while (i <= m && j <= h) {
      if (copy[i] <= copy[j]) {
        vec[k++] = copy[i++];
      } else {
        vec[k++] = copy[j++];
      }
    }
    while (i <= m) {
      vec[k++] = copy[i++];
    }
    while (j <= h) {
      vec[k++] = copy[j++];
    }
  }
};
