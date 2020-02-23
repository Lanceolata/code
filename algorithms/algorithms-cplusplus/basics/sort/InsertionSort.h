#include "Sort.h"

template<class T>
class InsertionSort : public Sort<T> {
 public:
  void sort(vector<T>& vec) {
    int n = vec.size();
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j > 0; j--) {
        if (vec[j] >= vec[j - 1]) {
          break;
        }
        swap(vec[j], vec[j - 1]);
      }
    }
  }
};
