
class Solution {
 public:
  int bitwiseComplement(int n) {
    if (n == 0) {
      return 1;
    }
    bool start = false;
    for (int i = 31; i >= 0; --i) {
      if (n & (1 << i)) {
        start = true;
      }
      if (start) {
        n ^= (1 << i);
      }
    }
    return n;
  }
};
