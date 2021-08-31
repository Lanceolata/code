#include <string>
#include <sstream>

using namespace std;

class Solution {
 public:
  string fractionAddition(string expression) {
    stringstream ss(expression);
    int A = 0, B = 1, a, b;
    char t;
    while (ss >> a >> t >> b) {
      A = A * b + a * B;
      B *= b;
      int g = abs(gcd(A, B));
      A /= g;
      B /= g;
    }
    return to_string(A) + '/' + to_string(B);
  }

  int gcd(int a, int b) {
    while (b != 0) {
      int t = b;
      b = a % b;
      a = t;
    }
    return a;
  }
};