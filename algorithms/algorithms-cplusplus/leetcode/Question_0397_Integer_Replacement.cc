#include <algorithm>

using namespace std;

class Solution {
 public:
  int integerReplacementRescursive(int n) {
    if (n == 1) {
      return 0;
    }
    if (n % 2 == 0) {
      return 1 + integerReplacementRescursive(n / 2);
    } else {
      long long t = n;
      return 2 + min(integerReplacementRescursive((t + 1) / 2), integerReplacementRescursive((t - 1) / 2));
    }
  }

  int integerReplacement(int n) {
    long long t = n;
    int cnt = 0;
    while (t > 1) {
      ++cnt;
      if (t & 1) {
        if ((t & 2) && (t != 3)) {
          ++t;
        } else {
          --t;
        }
      } else {
        t >>= 1;
      }
    }
    return cnt;
  }
};
