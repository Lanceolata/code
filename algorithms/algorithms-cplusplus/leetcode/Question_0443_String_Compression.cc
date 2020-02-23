#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  int compress(vector<char>& chars) {
    int i = 0, cnt = 1, n = chars.size();
    for (int j = 0; j < n; j++) {
      if (j + 1 < n && chars[j] == chars[j + 1]) {
        cnt++;
      } else {
        chars[i++] = chars[j];
        if (cnt > 1) {
          string count = to_string(cnt);
          for (char c : count) {
            chars[i++] = c;
          }
        }
        cnt = 1;
      }
    }
    return i;
  }
};
