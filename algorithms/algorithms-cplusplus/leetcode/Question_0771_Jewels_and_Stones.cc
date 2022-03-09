#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  int numJewelsInStones(string jewels, string stones) {
    vector<bool> isJewels(256, false);
    for (char c: jewels) {
      isJewels[c] = true;
    }
    int res = 0;
    for (char c : stones) {
      if (isJewels[c]) {
        res++;
      }
    }
    return res;
  }
};
