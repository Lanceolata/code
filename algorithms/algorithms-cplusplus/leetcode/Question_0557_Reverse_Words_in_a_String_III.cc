#include <string>

using namespace std;

class Solution {
 public:
  string reverseWords(string s) {
    size_t start = 0, end = 0, index = 0, len = s.size();
    if (len <= 0) return s;
    while (index < len) {
      start = index;
      while (start < len && s[start] == ' ') start++;
      end = start + 1;
      while (end < len && s[end] != ' ') end++;
      index = end;
      if (index <= len) {
        reverse(start, end - 1, s);
      }
    }
    return trim(s);
  }

  void reverse(size_t start, size_t end, string& s) {
    char tmp;
    while (start < end) {
      tmp = s[start];
      s[start++] = s[end];
      s[end--] = tmp;
    }
  }

  string& trim(string& s) {
    if (s.empty()) return s;
    s.erase(0,s.find_first_not_of(" "));
    s.erase(s.find_last_not_of(" ") + 1);
    return s;
  }
};
