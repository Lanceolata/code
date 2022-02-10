#include <vector>

using namespace std;

class Solution {
 public:
  vector<int> constructArray(int n, int k) {
    vector<int> res(n, 0);
    int i = 0;
    for (int j = 1; j < n - k; j++) {
      res[i++] = j;
    }
    for (int j = 0; j <= k; j++) {
      res[i++] = (j % 2 == 0) ? (n - k + j / 2) : (n - j / 2);
    }
    return res;
  }
};
