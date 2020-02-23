#ifndef ALGORITHM_BASICS_SORT_SORT_H_
#define ALGORITHM_BASICS_SORT_SORT_H_

#include <vector>

using namespace std;

template<class T>
class Sort {
 public:
  virtual ~Sort() {}

  virtual void sort(vector<T>& vec) = 0;
};

#endif  // ALGORITHM_BASICS_SORT_SORT_H_
