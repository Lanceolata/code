#include <math.h>
#include <algorithm>

using namespace std;

class Solution {
 public:
  int digitAtIndex(int index) {
    if (index < 0) {
      return -1;
    }
    int digits = 1;
    for (;; digits++) {
      int nums = countOfIntegers(digits);
      if (index < nums * digits) {
        break;
      }
      index -= digits * nums;
    }
    int number = beginNumber(digits) + index / digits;
    int indexFromRight = digits - index % digits;
    for (int i = 1; i < indexFromRight; i++) {
      number /= 10;
    }
    return number % 10;
  }

  int countOfIntegers(int digits) {
    if (digits == 1) {
      return 10;
    }
    int count = (int)pow(10, digits - 1);
    return 9 * count;
  }

  int beginNumber(int digits) {
    if (digits == 1) {
      return 0;
    }
    return (int)pow(10, digits - 1);
  }
};
