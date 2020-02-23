#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  vector<string> readBinaryWatch(int num) {
    vector<string> res;
    if (num < 0 || num > 10) {
      return res;
    }
    for (int h = 0; h < 12; h++) {
      for (int m = 0; m < 60; m++) {
        int n = (h << 6) | m;
        if (bitCount(n) == num) {
          res.emplace_back(to_string(h) + (m < 10 ? ":0" : ":") + to_string(m));
        }
      }
    }
    return res;
  }

  int bitCount(int n) {
    int res = 0;
    while (n != 0) {
      res++;
      n &= n - 1;
    }
    return res;
  }
};
