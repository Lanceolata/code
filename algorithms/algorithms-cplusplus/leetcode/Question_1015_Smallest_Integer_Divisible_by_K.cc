

class Solution {
 public:
  int smallestRepunitDivByK(int k) {
    if (k % 2 == 0 || k % 5 == 0) {
      return -1;
    }
    int r = 0;
    for (int n = 1; n <= k; n++) {
      r = (r * 10 + 1) % k;
      if (r == 0) {
        return n;
      }
    }
    return -1;
  }
};
