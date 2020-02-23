
class Solution {
 public:
  int mySqrt(int x) {
    long long res = x, raw = x;
    while (res * res > raw) {
      res = (res + raw / res) / 2;
    } 
    return (int)res;
  }

  int mySqrt2(int x) {
    long long low = 0, high = x, mid = x, raw = x;
    while (low <= high) {
      mid = high + (low - high) / 2;
      if (mid * mid > raw)
          high = mid - 1;
      else
          low = mid + 1;
    }
    return (int)high;
  }
};
