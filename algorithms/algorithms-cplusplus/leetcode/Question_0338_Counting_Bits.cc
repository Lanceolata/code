#include <vector>

using namespace std;

class Solution {
 public:
  vector<int> countBits(int n) {
    if (n < 0) {
      return vector<int>();
    }
    vector<int> res(n + 1, 0);
    for (int i = 1; i <= n; i++) {
      res[i] = res[i >> 1] + (i & 1);
    }
    return res;
  }
};
