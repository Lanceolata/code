#include <string>
#include <vector>
#include <unordered_set>

using namespace std;

class Solution {
 public:
  bool buddyStrings(string s, string goal) {
    if (s.size() != goal.size()) {
      return false;
    }
    if (s == goal) {
      unordered_set<char> charSet;
      for (char c : s) {
        charSet.insert(c);
      }
      return charSet.size() != s.size();
    }
    vector<int> dif;
    for (int i = 0; i < s.size(); i++) {
      if (s[i] != goal[i]) {
        dif.push_back(i);
      }
    }
    return dif.size() == 2 && s[dif[0]] == goal[dif[1]] && s[dif[1]] == goal[dif[0]];
  }
};
