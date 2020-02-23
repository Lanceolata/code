#include <string>

using namespace std;

class Solution {
 public:
  int countSegments(string s) {
    int res = 0;
    for (int i = 0; i < s.size(); i++) {
      if ((i == 0 || s.charAt(i-1) == ' ') && s.charAt(i) != ' ') {
        res++;
      }
    }
    return res;
  }
};
