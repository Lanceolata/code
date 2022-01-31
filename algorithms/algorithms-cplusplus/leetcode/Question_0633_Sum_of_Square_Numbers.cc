
class Solution {
 public:
  bool judgeSquareSum(int c) {
    for (long long a = 0; a * a <= c; a++) {
      long long b = c - a * a;
      if (help(0, b, b)) {
        return true;
      }
    }
    return false;
  }

  bool help(long long l, long long r, long long n) {
    long long m, t;
    while (l <= r) {
      m = l + (r - l) / 2;
      t = m * m;
      if (t == n) {
        return true;
      }
      if (t < n) {
        l = m + 1;
      } else {
        r = m - 1;
      }
    }
    return false;
  }

  bool judgeSqujudgeSquareSum_fermatareSum(int c) {
    for (int i = 2; i * i <= c; i++) {
      int count = 0;
      if (c % i == 0) {
        while (c % i == 0) {
          count++;
          c /= i;
        }
        if (i % 4 == 3 && count % 2 != 0) {
          return false;
        }
      }
    }
    return c % 4 != 3;
  }
};
