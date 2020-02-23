
class Solution {
 public:
  int countDigitOne(int n) {
    long long res = 0, high = 0, cur = 0, low = 0;
    for (long long i = 1; i <= n; i *= 10) {
      high = n / (i * 10);
      cur = (n / i) % 10;
      low = n % i;
      if (cur == 0) {
        res += high * i;
      } else if (cur == 1) {
        res += high * i + low + 1;
      } else {
        res += (high + 1) * i;
      }
    }
    return (int)res;
  }
};
