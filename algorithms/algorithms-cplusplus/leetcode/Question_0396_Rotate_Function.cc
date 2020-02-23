#include <vector>

using namespace std;

class Solution {
 public:
  int maxRotateFunction(vector<int>& A) {
    long sum = 0, F = 0;
    int n = A.size();
    for (int i = 0; i < n; i++) {
      F += i * A[i];
      sum += A[i];
    }
    long res = F;
    for (int i = n - 1; i >= 1; i--) {
      F = F + sum - (long)(n) * A[i];
      res = max(res, F);
    }
    return (int)res;
  }
};
