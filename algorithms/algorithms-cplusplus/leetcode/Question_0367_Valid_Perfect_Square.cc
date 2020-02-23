
class Solution {
 public:
  bool isPerfectSquare(int num) {
    if (num < 2) {
      return true;
    }
    long long x = num / 2;
    while (x * x > num) {
      x = (x + num / x) / 2;
    }
    return x * x == num;
  }

  bool isPerfectSquare_dichotomy(int num) {
    if (num < 2) {
      return true;
    }
    long long l = 0, r = num / 2, m;
    while (l <= r) {
      m = l + (r - l) / 2;
      if (m * m == num) {
        return true;
      } else if (m * m < num) {
        l = m + 1;
      } else {
        r = m - 1;
      }
    }
    return false;
  }
};
