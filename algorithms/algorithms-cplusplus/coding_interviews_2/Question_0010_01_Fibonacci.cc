
class Solution {
 public:
  int Fibonacci(int n) {
    if (n <= 0) {
      return 0;
    }
    int first = 1, second = 1, third;
    for (int i = 3; i <= n; i++) {
      third = first + second;
      first = second;
      second = third;
    }
    return second;
  }
};
