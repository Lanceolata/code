#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  bool isAnagram(string s, string t) {
    if (s.size() != t.size()) {
      return false;
    }
    vector<int> vec(26, 0);
    for (size_t i = 0; i < s.size(); i++) {
      vec[s[i] - 'a']++;
      vec[t[i] - 'a']--;
    }
    for (int i : vec) {
      if (i != 0) {
        return false;
      }
    }
    return true;
  }
};
