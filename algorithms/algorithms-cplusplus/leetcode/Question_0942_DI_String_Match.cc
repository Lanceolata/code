#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  vector<int> diStringMatch(string s) {
    int l = 0, r = s.size();
    vector<int> res;
    for (char c : s) {
      if (c == 'I') {
        res.push_back(l++);
      } else {
        res.push_back(r--);
      }
    }
    res.push_back(l);
    return res;
  }
};
