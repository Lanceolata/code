#include <vector>

class Solution {
 public:
  int countPrimes(int n) {
    if (n <= 0) {
      return 0;
    }
    std::vector<bool> prime(n, true);
    int res = 0;
    for (int i = 2; i < n; i++) {
      if (prime[i]) {
        res++;
        for (int j = 2; i * j < n; j++) {
          prime[i * j] = false;
        }
      }
    }
    return res;
  }
};
