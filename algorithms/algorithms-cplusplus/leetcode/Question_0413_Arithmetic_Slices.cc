#include <vector>

using namespace std;

class Solution {
 public:
  int numberOfArithmeticSlices1(vector<int>& A) {
    int sum = 0;
    slices(A, A.size() - 1, sum);
    return sum;
  }

  int slices(vector<int>& A, int i, int& sum) {
    if (i < 2) {
      return 0;
    }
    int ap = 0;
    if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
      ap = 1 + slices(A, i - 1, sum);
      sum += ap;
    } else {
      slices(A, i - 1, sum);
    }
    return ap;
  }

  int numberOfArithmeticSlices2(vector<int>& A) {
    int res = 0, n = A.size();
    vector<int> dp(n, 0);
    for (int i = 2; i < n; ++i) {
      if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
        dp[i] = dp[i - 1] + 1;
      }
      res += dp[i];
    }
    return res;
  }

  int numberOfArithmeticSlices(vector<int>& A) {
    int res = 0, cur = 0;
    for (int i = 2; i < A.size(); ++i) {
      if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
        cur += 1;
        res += cur;
      } else {
        cur = 0;
      }
    }
    return res;
  }
};
