#include <string>

using namespace std;

class Solution {
 public:
  int titleToNumber(string columnTitle) {
    int res = 0;
    for (size_t i = 0; i < columnTitle.size(); i++) {
      res = res * 26 + (columnTitle[i] - 'A' + 1);
    }
    return res;
  }
};
