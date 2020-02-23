#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  int longestPalindrome(string s) {
    if (s.empty()) {
      return 0;
    }
    vector<int> vec(256, 0);
    for (char c : s) {
      vec[c]++;
    }
    int res = 0;
    for (int i : vec) {
      res += i / 2 * 2;
    }
    return res == s.size() ? res : res + 1;
  }
};
