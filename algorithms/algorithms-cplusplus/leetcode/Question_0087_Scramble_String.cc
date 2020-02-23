#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  bool isScramble(string s1, string s2) {
    if (s1 == s2) return true;
    int len = s1.size();
    vector<int> vec(26, 0);
    for (size_t i = 0; i < len; i++) {
      vec[s1[i] - 'a']++;
      vec[s2[i] - 'a']--;
    }
    for (int i = 0; i < 26; i++) {
      if (vec[i] != 0) {
        return false;
      }
    }
    for (int i = 1; i < len; i++) {
      if(isScramble(s1.substr(0,i), s2.substr(0,i)) && isScramble(s1.substr(i), s2.substr(i))) {
        return true;
      }
      if (isScramble(s1.substr(0,i), s2.substr(len-i)) && isScramble(s1.substr(i), s2.substr(0,len-i))) {
        return true;
      }
    }
    return false;
  }
};
