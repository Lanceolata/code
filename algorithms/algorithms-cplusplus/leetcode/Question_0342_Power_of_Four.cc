
class Solution {
 public:
  bool isPowerOfFour(int num) {
    return num > 0 && ((num & (num - 1)) == 0) && (num - 1) % 3 == 0;
  }

  bool isPowerOfFour2(int num) {
    return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
  }
};
