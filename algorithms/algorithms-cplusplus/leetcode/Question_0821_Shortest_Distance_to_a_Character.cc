#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  vector<int> shortestToChar(string s, char c) {
    int n = s.size();
    vector<int> res(n, n);
    int idx = -1;
    for (int i = 0; i < n; i++) {
      if (s[i] == c) {
        idx = i;
      }
      if (idx != -1) {
        res[i] = min(res[i], i - idx);
      }
    }
    idx = -1;
    for (int i = n - 1; i >= 0; i--) {
      if (s[i] == c) {
        idx = i;
      }
      if (idx != -1) {
        res[i] = min(res[i], idx - i);
      }
    }
    return res;
  }
};
