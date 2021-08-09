#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  string findLongestWord(string s, vector<string>& dictionary) {
    string res = "";
    for (string str : dictionary) {
      int i = 0;
      for (char c : s) {
        if (i < str.size() && c == str[i]) {
          ++i;
        }
      }
      if (i == str.size() && str.size() >= res.size()) {
        if (str.size() > res.size() || str < res) {
          res = str;
        }
      }
    }
    return res;
  }
};
