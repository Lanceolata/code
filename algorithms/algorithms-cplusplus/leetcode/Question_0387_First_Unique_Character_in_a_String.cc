#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  int firstUniqChar(string s) {
    if (s.empty()) {
      return -1;
    }
    vector<int> vec(256, 0);
    for (char c : s) {
      vec[c]++;
    }
    for (int i = 0; i < s.size(); i++) {
      if (vec[s[i]] == 1) {
        return i;
      }
    }
    return -1;
  }
};
