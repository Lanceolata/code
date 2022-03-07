#include <unordered_set>
#include <unordered_map>

using namespace std;

class Solution {
 public:
  int countPrimeSetBits(int left, int right) {
    int res = 0;
    unordered_set<int> primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    for (int i = left; i <= right; i++) {
      int bits = countBits(i);
      if (primes.count(bits)) {
        res++;
      }
    }
    return res;
  }

 private:
  int countBits(int n) {
    int res = 0;
    while (n) {
      res++;
      n &= n - 1;
    }
    return res;
  }
};
