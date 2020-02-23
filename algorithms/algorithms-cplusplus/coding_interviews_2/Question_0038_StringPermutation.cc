#include <vector>
#include <string>
#include <set>

using namespace std;

class Solution {
 public:
  vector<string> Permutation(string str) {
    vector<string> res;
    if (str.empty()) {
      return res;
    }
    set<string> s;
    help(str, 0, s);
    for (auto i : s) {
      res.push_back(i);
    }
    return res;
  }

  void help(string& str, int i, set<string>& s) {
    if (i >= str.size()) {
      s.insert(str);
      return;
    }
    for (int j = i; j < str.size(); j++) {
      swap(str[i], str[j]);
      help(str, i + 1, s);
      swap(str[i], str[j]);
    }
  }
};
