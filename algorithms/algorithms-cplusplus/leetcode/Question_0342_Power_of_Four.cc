
class Solution {
 public:
  bool isPowerOfFour(int n) {
    return n > 0 && ((n & (n - 1)) == 0) && (n - 1) % 3 == 0;
  }

  bool isPowerOfFour2(int n) {
    return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
  }
};
