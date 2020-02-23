#include <vector>

using namespace std;

class Solution {
 public:
  vector<int> grayCode(int n) {
    // 自然二进制码转换成二进制格雷码，
    // 其法则是保留自然二进制码的最高位作为格雷码的最高位
    // 而次高位格雷码为二进制码的高位与次高位相异或
    // 而格雷码其余各位与次高位的求法相类似。      
    if (n == 0) {
      return {0};
    }
    int num = 1;
    for (int i = 1; i <= n; i++) {
      num <<= 1;
    }
    vector<int> res;
    for (int i = 0; i < num; i++) {
      // G(i) = i ^ (i/2)
      res.push_back(i ^ (i >> 1));
    }
    return res;
  }
};
