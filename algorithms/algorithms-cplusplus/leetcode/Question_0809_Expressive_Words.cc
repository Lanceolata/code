#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  int expressiveWords(string s, vector<string>& words) {
    int res = 0;
    for (string& w : words) {
      if (check(s, w)) {
        res++;
      }
    }
    return res;
  }

 private:
  bool check(string& s, string& w) {
    int i = 0, j = 0;
    while (i < s.size() && j < w.size()) {
      if (s[i] == w[j]) {
        int len1 = getRepeatedLength(s, i);
        int len2 = getRepeatedLength(w, j);
        if ((len1 < 3 && len1 != len2) || (len1 >= 3 && len1 < len2)) {
          return false;
        }
        i += len1;
        j += len2;
      } else {
        return false;
      }
    }
    return i == s.size() && j == w.size();
  }

  int getRepeatedLength(string& s, int i) {
    int j = i;
    while (j < s.size() && s[i] == s[j]) {
      j++;
    }
    return j - i;
  }
};
