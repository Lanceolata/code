#include <vector>

using namespace std;

class Solution {
 public:
  void reOrderArray(vector<int> &array) {
    int n = array.size();
    bool isOrdered = false;
    for (int i = n - 1; i > 0 && !isOrdered; i--) {
      isOrdered = true;
      for (int j = 0; j < i; j++) {
        if (!isOdd(array[j]) && isOdd(array[j + 1])) {
          isOrdered = false;
          swap(array[j], array[j + 1]);
        }
      }
    }
  }

  bool isOdd(int n) {
    return (n & 1) != 0;
  }
};
