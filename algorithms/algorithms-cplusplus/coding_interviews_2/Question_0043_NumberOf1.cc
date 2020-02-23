
class Solution {
 public:
  int NumberOf1Between1AndN_Solution(int n) {
    int count = 0;
    long long i=1;
    int high = 0, cur = 0, low = 0;
    for(i = 1; i <= n; i *= 10) {
      high = n / (i * 10); // 高位
      cur = (n / i) % 10;  // 当前位
      low = n % i;         // 低位
      if (cur == 0) {
        count += high * i;
      } else if (cur == 1) {
        count += high * i + low + 1;
      } else {
        count += (high + 1) * i;
      }
    }
    return count;
  }
};
