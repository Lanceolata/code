#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  vector<vector<int>> largeGroupPositions(string s) {
    vector<vector<int>> res;
    int mlen = 0;
    for (int i = 0, j = 0; j < s.size(); j++) {
      while (j + 1 < s.size() && s[j] == s[j + 1]) {
        j++;
      }
      if (j - i + 1 >= 3) {
        res.push_back({i, j});
      }
      i = j + 1;
    }
    return res;
  }
};
