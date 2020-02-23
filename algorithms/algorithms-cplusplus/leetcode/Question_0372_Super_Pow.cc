#include <vector>

using namespace std;

class Solution {
 public:
  int superPow(int a, vector<int>& b) {
    if (a == 0) {
      return 0;
    }
    int res = 1;
    for (int i = 0; i < b.size(); i++) {
      res = powmod(res, 10) * powmod(a, b[i]) % base;
    }
    return res;
  }

 private:
  const int base = 1337;

  int powmod(int x, int n) {
    if (n == 0) {
      return 1;
    }
    int t = powmod(x, n >> 1) % base;
    if ((n & 1) == 1) {
      t = (x % base) * ((t * t) % base) % base;
    } else {
      t = (t * t) % base;
    }
    return t;
  }
};
