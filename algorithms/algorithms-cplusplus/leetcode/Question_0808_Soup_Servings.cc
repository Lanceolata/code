#include <unordered_map>

using namespace std;

class Solution {
 public:
  double soupServings(int n) {
    if (n >= 4800) {
      return 1.0;
    } else {
      return help(n, n);
    }
  }

 private:
  double help(int A, int B) {
    if (A == 0 && B != 0) {
      return 1;
    } else if (A == 0 && B == 0) {
      return 0.5;
    } else if (A != 0 && B == 0) {
      return 0;
    }
    if (store[A][B] != 0) {
      return store[A][B];
    }
    double prob = 0;
    prob += 0.25 * help(A - min(A, 100), B);
    prob += 0.25 * help(A - min(A, 75), B - min(B, 25));
    prob += 0.25 * help(A - min(A, 50), B - min(B, 50));
    prob += 0.25 * help(A - min(A, 25), B - min(B, 75));
    store[A][B] = prob;
    return prob;
  }

  unordered_map<int, unordered_map<int, double>> store;
};
