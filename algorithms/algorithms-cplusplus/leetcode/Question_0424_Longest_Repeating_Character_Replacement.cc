#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  int characterReplacement(string s, int k) {
    int res = 0, maxCount = 0;
    vector<int> vec(26, 0);
    for (int i = 0, j = 0; j < s.length(); j++) {
      maxCount = max(maxCount, ++vec[s[j] - 'A']);
      while (j - i + 1 - maxCount > k) {
        --vec[s[i] - 'A'];
        i++;
      }
      res = max(res, j - i + 1);
    }
    return res;
  }
};
