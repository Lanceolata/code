#include <string>

using namespace std;

class Solution {
 public:
  bool detectCapitalUse(string word) {
    if (word.empty()) {
      return false;
    }
    int up = 0;
    for (int i = 0; i < word.size(); i++) {
      if (word[i] >= 'A' && word[i] <= 'Z') {
        up++;
      }
    }
    return up == word.size() || up == 0 || (up == 1 && word[0] >= 'A' && word[0] <= 'Z');
  }
};
