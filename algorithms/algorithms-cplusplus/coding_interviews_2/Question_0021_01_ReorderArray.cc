#include <vector>

using namespace std;

class Solution {
 public:
  void reOrderArray(vector<int> &array) {
    if (array.size() <2) {
      return;
    }
    int l = 0, r = array.size() - 1;
    while (l < r) {
      while (l < r && isOdd(array[l])) {
        l++;
      }
      while (l < r && !isOdd(array[r])) {
        r--;
      }
      if (l < r) {
        swap(array[l], array[r]);
      }
    }
  }

  bool isOdd(int n) {
    return (n & 1) != 0;
  }
};
