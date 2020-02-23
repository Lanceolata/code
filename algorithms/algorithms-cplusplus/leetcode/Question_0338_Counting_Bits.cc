#include <vector>

using namespace std;

class Solution {
 public:
  vector<int> countBits(int num) {
    if (num < 0) {
      return vector<int>();
    }
    vector<int> res(num + 1, 0);
    for (int i = 1; i <= num; i++) {
      res[i] = res[i >> 1] + (i & 1);
    }
    return res;
  }
};
