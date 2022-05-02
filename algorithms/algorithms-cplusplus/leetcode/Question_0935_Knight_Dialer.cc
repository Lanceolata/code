#include <vector>

using namespace std;

class Solution {
 public:
  int knightDialer(int n) {
    if (n == 1) {
      return 10;
    }
    int MOD = 1e9 + 7;
    vector<vector<int>> MOVES = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0}, {}, {1, 7, 0}, {2, 6}, {1, 3}, {4, 2}};
    vector<int> vec(10, 1);
    for (int i = 1; i < n; i++) {
      vector<int> newVec(10, 0);
      for (int j = 0; j < 10; j++) {
        for (int m : MOVES[j]) {
          newVec[m] = (newVec[m] + vec[j]) % MOD;
        }
      }
      vec = newVec;
    }
    long res = 0;
    for (long i : vec) {
      res += i;
    }
    return (int) (res % MOD);
  }
};
