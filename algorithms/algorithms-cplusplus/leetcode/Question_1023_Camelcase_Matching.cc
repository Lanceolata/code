#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  vector<bool> camelMatch(vector<string>& queries, string pattern) {
    vector<bool> res;
    for (string &query : queries) {
      res.push_back(help(query, pattern));
    }
    return res;
  }

  bool help(string query, string pattern) {
    int i = 0;
    for (char& c : query) {
      if (i < pattern.length() && c == pattern[i]) {
        i++;
      } else if (c < 'a') {
        return false;
      }
    }
    return i == pattern.length();
  }
};
