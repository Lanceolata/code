#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  vector<string> letterCombinations(string digits) {
    vector<string> res;
    if (digits.empty()) {
      return res;
    }
    vector<string> dict = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    string s = "";
    dfs(digits, dict, 0, s, res);
    return res;
  }

  void dfs(string& digits, vector<string>& dict, int i, string& s, vector<string>& res) {
    if (i >= digits.size()) {
      res.push_back(s);
      return;
    }
    for (char c : dict[digits[i] - '2']) {
      s.push_back(c);
      dfs(digits, dict, i + 1, s, res);
      s.pop_back();
    }
  }
};
