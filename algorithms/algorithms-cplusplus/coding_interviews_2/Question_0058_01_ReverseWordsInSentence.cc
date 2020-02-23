#include <string>

using namespace std;

class Solution {
 public:
  string ReverseSentence(string str) {
    if (str.empty()) {
      return str;
    }
    int n = str.size();
    for (int l = 0, r = 0; r <= n; r++) {
      if (r == n || str[r] == ' ') {
        reverse(str, l, r - 1);
        l = r + 1;
      }
    }
    reverse(str, 0, n - 1);
    return str;
  }

  void reverse(string& str, int l, int r) {
    while (l < r) {
      swap(str[l++], str[r--]);
    }
  }
};
