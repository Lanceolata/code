#include <math.h>

using namespace std;

class Solution {
 public:
  int findNthDigit(int n) {
    if (n < 0) {
      return -1;
    }
    int digits = 1;
    for (;; digits++) {
      int nums = countOfIntegers(digits);
      if ((long)n < (long)nums * digits) {
        break;
      }
      n -= digits * nums;
    }
    int number = beginNumber(digits) + n / digits;
    int indexFromRight = digits - n % digits;
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
