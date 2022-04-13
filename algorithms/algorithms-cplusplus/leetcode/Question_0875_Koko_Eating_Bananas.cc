#include <vector>

using namespace std;

class Solution {
 public:
  int minEatingSpeed(vector<int>& piles, int h) {
    int l = 1, r = *max_element(piles.begin(), piles.end()), m;
    while (l < r) {
      m = l + (r - l) / 2;
      int spent = 0;
      for (int p : piles) {
        spent += p / m + (p % m != 0);
      }
      if (spent <= h) {
        r = m;
      } else {
        l = m + 1;
      }
    }
    return r;
  }
};
