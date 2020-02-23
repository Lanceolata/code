#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  string minWindow(string s, string t) {
    vector<int> map(128,0);
    for(auto c: t) {
      map[c]++;
    }
    int left = 0, cnt = 0, minLen = INT_MAX, begin = -1;
    for (int i = 0; i < s.size(); i++) {
      if (map[s[i]]-- > 0) {
        cnt++;
      }
      while (cnt == t.size()) {
        if (minLen > i - left + 1) {
          minLen = i - left + 1;
          begin = left;
        }
        if (++map[s[left]] > 0) {
          --cnt;
        }
        left++;
      }
    }
    if (begin < 0) {
      return "";
    }
    return s.substr(begin, minLen);
  }
};
