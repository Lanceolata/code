#include <vector>

using namespace std;

class Solution {
 public:
  vector<int> multiply(const vector<int>& A) {
    if (A.size() <= 1) {
      return vector<int>();
    }
    vector<int> res(A.size());
    int tmp = 1, n = A.size();
    for (int i = 0; i < n; i++) {
      res[i] = tmp;
      tmp *= A[i];
    }
    tmp = 1;
    for (int i = n - 1; i >= 0; i--) {
      res[i] *= tmp;
      tmp *= A[i];
    }
    return res;
  }
};
