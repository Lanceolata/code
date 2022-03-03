#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  vector<int> selfDividingNumbers(int left, int right) {
    vector<int> res;
    for (int i = left; i <= right; i++) {
      if (isSelfDividing(i)) {
        res.push_back(i);
      }
    }
    return res;
  }

 private:
  bool isSelfDividing(int n) {
    string s = to_string(n);
    for (char c : s) {
      if (c == '0' || n % (c - '0') != 0) {
        return false;
      }
    }
    return true;
  }
};
