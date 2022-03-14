#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  string customSortString(string order, string s) {
    vector<int> cnt(26, 0);
    for (char c : s) {
      cnt[c - 'a']++;
    }
    string res;
    for (char c : order) {
      for (int i = 0; i < cnt[c - 'a']; i++) {
        res.push_back(c);
      }
      cnt[c - 'a'] = 0;
    }
    for (int i = 0; i < 26; i++) {
      for (int j = 0; j < cnt[i]; j++) {
        res.push_back('a' + i);
      }
    }
    return res;
  }
};
