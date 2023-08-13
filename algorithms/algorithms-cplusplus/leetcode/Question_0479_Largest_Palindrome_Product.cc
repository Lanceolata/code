#include <math.h>

class Solution {
 public:
  int largestPalindrome(int n) {
    if (n == 1) {
      return 9;
    }
    double max = pow(10, n) - 1;
    long high = (long)max, low = (long)(max / 10);
    for (long i = high; i > low; i--) {
      long palindrome = (long)(i * pow(10, n)) + reverse(i);
      for (long j = high; j > low; j--) {
        if (palindrome / j > high) {
          break;
        }
        if (palindrome % j == 0) {
          return palindrome % 1337;
        }
      }
    }
    return -1;
  }

  long reverse(long num) {
    long rev = 0;
    while (num) {
      rev = rev * 10 + num % 10;
      num /= 10;
    }
    return rev;
  }
};
