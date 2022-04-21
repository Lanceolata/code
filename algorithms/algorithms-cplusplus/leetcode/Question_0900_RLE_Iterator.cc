#include <vector>

using namespace std;

class RLEIterator {
 public:
  RLEIterator(vector<int>& encoding): vec(encoding), index(0) {
  }

  int next(int n) {
    while (index < vec.size() && n > vec[index]) {
      n = n - vec[index];
      index += 2;
    }
    if (index >= vec.size()) {
      return -1;
    }
    vec[index] = vec[index] - n;
    return vec[index + 1];
  }

 private:
  vector<int> vec;
  int index;
};

