#include <string>

using namespace std;

class Solution {
 public:
  bool isAdditiveNumber(string num) {
    int n = num.length();
    for (int i = 1; i <= n / 2; i++) {
      for (int j = 1; max(i, j) <= n - i - j; j++) {
        if (isValid(num, i, j)) {
          return true;
        }
      }
    }
    return false;
  }

  bool isValid(string& num, int i, int j) {
    if (num[0] == '0' && i > 1) {
      return false;
    }
    if (num[i] == '0' && j > 1) {
      return false;
    }
    string sum;
    long long x1 = stoll(num.substr(0, i));
    long long x2 = stoll(num.substr(i, j));
    for (int start = i + j; start < num.size(); start += sum.size()) {
      x2 = x2 + x1;
      x1 = x2 - x1;
      sum = to_string(x2);
      if (start + sum.size() > num.size() || num.substr(start, sum.size()) != sum) {
        return false;
      }
    }
    return true;
  }
};
