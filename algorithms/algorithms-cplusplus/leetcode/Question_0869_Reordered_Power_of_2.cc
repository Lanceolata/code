#include <math.h>

using namespace std;

class Solution {
 public:
  bool reorderedPowerOf2(int n) {
    long c = counter(n);
    for (int i = 0; i < 32; i++) {
      if (counter(1 << i) == c) {
        return true;
      }
    }
    return false;
  }

 private:
  long counter(int n) {
    long res = 0;
    for (; n != 0; n /= 10) {
      res += pow(10, n % 10);
    }
    return res;
  }
};
