#include "Sort.h"

template<class T>
class BubbleSort : public Sort<T> {
 public:
  void sort(vector<T>& vec) {
    int n = vec.size();
    bool isOrdered = false;
    for (int i = n - 1; i > 0 && !isOrdered; i--) {
      isOrdered = true;
      for (int j = 0; j < i; j++) {
        if (vec[j] > vec[j + 1]) {
          isOrdered = false;
          swap(vec[j], vec[j + 1]);
        }
      }
    }
  }
};
