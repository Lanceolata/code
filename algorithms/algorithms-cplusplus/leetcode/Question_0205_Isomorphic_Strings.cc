#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  bool isIsomorphic(string s, string t) {
    if (s.size() != t.size()) {
      return false;
    }
    vector<int> vec1(128, -1), vec2(128, -1);
    for (int i = 0; i < t.size(); i++) {
      if (vec1[s[i]] != vec2[t[i]]) {
        return false;
      }
      vec1[s[i]] = vec2[t[i]] = i;
    }
    return true;
  }
};
