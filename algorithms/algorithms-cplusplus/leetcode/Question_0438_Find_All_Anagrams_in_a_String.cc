#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  vector<int> findAnagrams(string s, string p) {
    if (s.empty()) {
      return {};
    }
    vector<int> res, m(256, 0);
    for (char c : p) {
      ++m[c];
    }
    int cnt = p.size();
    for (int i = 0, j = 0; j < s.size(); j++) {
      if (m[s[j]]-- > 0) {
        cnt--;
      }
      if (cnt == 0) {
        res.push_back(i);
      }
      if (j - i == p.size() && m[s[i]]++ >= 0) {
        cnt++;
      }
    }
    return res;
  }
};
