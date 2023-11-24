#include <string>

using namespace std;

class Solution {
 public:
  string smallestSubsequence(string s) {
    int m[256] = {0}, visited[256] = {0};
    string res = "0";
    for (int i = 0; i < s.size(); i++) {
      m[s[i]]++;
    }
    for (int i = 0; i < s.size(); i++) {
      char c = s[i];
      m[c]--;
      if (visited[c]) {
        continue;
      }
      while (c < res.back() && m[res.back()]) {
        visited[res.back()] = 0;
        res.pop_back();
      }
      res += c;
      visited[c] = 1;
    }
    return res.substr(1);
  }
};
