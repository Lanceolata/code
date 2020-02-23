#include <unordered_set>

using namespace std;

class Solution {
 public:
  bool isHappy(int n) {
    unordered_set<int> set;
    while (set.insert(n).second) {
      n = digitSquareSum(n);
      if (n == 1) {
        return true;
      }
    }
    return false;
  }

  bool isHappy_other(int n) {
    int slow = n, fast = n;
    do {
      slow = digitSquareSum(slow);
      fast = digitSquareSum(fast);
      fast = digitSquareSum(fast);
    } while (slow != fast);
    return slow == 1;
  }

  int digitSquareSum(int n) {
    int sum = 0, tmp;
    while (n) {
      tmp = n % 10;
      sum += tmp * tmp;
      n /= 10;
    }
    return sum;
  }
};
