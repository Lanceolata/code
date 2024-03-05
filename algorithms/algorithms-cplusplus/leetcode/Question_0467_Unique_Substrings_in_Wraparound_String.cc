#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  int findSubstringInWraproundString(string s) {
    vector<int> cnt(26, 0);
    int res = 0, len = 0;
    for (int i = 0; i < s.size(); ++i) {
      int cur = s[i] - 'a';
      if (i > 0 && s[i - 1] != (cur + 26 - 1) % 26 + 'a') {
        len = 0;
      }
      if (++len > cnt[cur]) {
        res += len - cnt[cur];
        cnt[cur] = len;
      }
    }
    return res;
  }
};
