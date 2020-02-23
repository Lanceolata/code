#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  vector<vector<string>> partition(string s) {
    vector<vector<string>> res;
    vector<string> vec;
    help(s, 0, vec, res);
    return res;
  }

  void helper(string& s, size_t pos, vector<string>& vec, vector<vector<string>>& res) {
    if (pos >= s.size()) {
      res.push_back(vec);
      return;
    }
    for (size_t i = pos; i < s.size(); i++) {
      if (isPalindrome(s, pos, i)) {
        vec.push_back(s.substr(pos, i - pos + 1));
        help(s, i + 1, vec, res);
        vec.pop_back();
      }
    }
  }

  bool isPalindrome(string& s, size_t l, size_t r) {
    while (l < r) {
      if (s[l] != s[r]) return false;
      l++; r--;
    }
    return true;
  }
};
