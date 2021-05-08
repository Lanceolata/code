#include <string>
#include <vector>
#include <unordered_map>
#include <algorithm>

using namespace std;

class Solution {
 public:
  vector<vector<int>> palindromePairs(vector<string>& words) {
    vector<vector<int>> res;
    if (words.size() < 2) {
      return res;
    }
    unordered_map<string, int> m;
    for (int i = 0; i < words.size(); i++) {
      m[words[i]] = i;
    }
    for (int i = 0; i < words.size(); i++) {
      for (int j = 0; j <= words[i].size(); j++) {
        string s1 = words[i].substr(0, j);
        string s2 = words[i].substr(j);
        if (isPalindrome(s1)) {
          string rvs(s2.rbegin(), s2.rend());
          if(m.count(rvs) && m[rvs] != i) {
            res.push_back({m[rvs], i});
          }
        }
        if (!s2.empty() && isPalindrome(s2)) {
          string rvs(s1.rbegin(), s1.rend());
          if(m.count(rvs) && m[rvs] != i) {
            res.push_back({i, m[rvs]});
          }
        }
      }
    }
    return res;
  }

  bool isPalindrome(string s) {
    int l = 0, r = s.length() - 1;
    while (l <= r) {
      if (s[l++] !=  s[r--]) {
        return false;
      }
    }
    return true;
  }
};
