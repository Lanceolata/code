
class Solution {
 public:
  int getSum(int a, int b) {
    while (b != 0) {
      int tmp = a ^ b;
      b = (a & b & 0xffffffff) << 1;    // limit 32bit
      a = tmp;
    }
    return a;
  }
};
