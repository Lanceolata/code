#include <string>

using namespace std;

class Solution {
 public:
  int maximumSwap(int num) {
    string s = to_string(num);
    int maxidx = -1; int maxdigit = -1;
    int leftidx = -1; int rightidx = -1;
    for (int i = s.size() - 1; i >= 0; i--) {
      if (s[i] > maxdigit) {
        maxdigit = s[i];
        maxidx = i;
        continue;
      }
      if (s[i] < maxdigit) {
        leftidx = i;
        rightidx = maxidx;
      }
    }
    if (leftidx == -1) {
      return num;
    }
    swap(s[leftidx], s[rightidx]);
    return stoi(s);
  }
};
