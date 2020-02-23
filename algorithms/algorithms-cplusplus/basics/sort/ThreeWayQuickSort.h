#include "Sort.h"

template<class T>
class ThreeWayQuickSort : public Sort<T> {
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
    T v = vec[l];
    int lt = l, i = l + 1, gt = h;
    while (i <= gt) {
      if (vec[i] < v) {
        swap(vec[lt++], vec[i++]);
      } else if (vec[i] > v) {
        swap(vec[i], vec[gt--]);
      } else {
        i++;
      }
    }
    sort(vec, l, lt - 1);
    sort(vec, gt + 1, h);
  }
};
