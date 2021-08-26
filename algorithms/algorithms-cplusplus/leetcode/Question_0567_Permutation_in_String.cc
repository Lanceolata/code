#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  bool checkInclusion(string s1, string s2) {
    if (s1.size() > s2.size()) {
      return false;
    }
    vector<int> index(256, 0);
    for (int i = 0; i < s1.size(); i++) {
      index[s1[i]]++;
    }
    int cnt = 0;
    for (int i = 0, j = 0; j < s2.size(); j++) {
      if (j >= s1.size() && index[s2[i++]]++ >= 0) {
        cnt--;
      }
      if (index[s2[j]]-- > 0) {
        cnt++;
      }
      if (cnt == s1.size()) {
        return true;
      }
    }
    return false;
  }
};
