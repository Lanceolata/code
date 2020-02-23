#include "Sort.h"

template<class T>
class ShellSort : public Sort<T> {
 public:
  void sort(vector<T>& vec) {
    int n = vec.size(), h = 1;
    while (h < n / 3) {
      h = h * 3 + 1;
    }
    while (h > 0) {
      for (int i = h; i < n; i++) {
        for (int j = i; j >= h && vec[j] < vec[j - h]; j -= h) {
          swap(vec[j], vec[j - h]);
        }
      }
      h /= 3;
    }
  }
};
