#include <string>

using namespace std;

class Solution {
 public:
  string solveEquation(string equation) {
    int sign = 1, lhs = 0, rhs = 0, n = equation.size();
    for (int i = 0, j = 0; j <= n; j++) {
      if (j == n || equation[j] == '+' || equation[j] == '-') {
        if (j > i) {
          rhs += sign * stoi(equation.substr(i, j - i));
        }
        i = j;
      } else if (equation[j] == 'x') {
        if (i == j || equation[j - 1] == '+') {
          lhs += sign;
        } else if (equation[j - 1] == '-') {
          lhs -= sign;
        } else {
          lhs += sign * stoi(equation.substr(i, j - i));
        }
        i = j + 1;
      } else if (equation[j] == '=') {
        if (j > i) {
          rhs += sign * stoi(equation.substr(i, j - i));
        }
        sign = -1;
        i = j+1;
      }
    }
    if (lhs == 0) {
      if (rhs == 0) {
        return "Infinite solutions";
      } else {
        return "No solution";
      }
    }
    return "x=" + to_string(-rhs / lhs);
  }
};