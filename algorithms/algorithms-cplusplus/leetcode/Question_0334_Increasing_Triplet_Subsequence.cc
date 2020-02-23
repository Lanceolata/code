#include <limits.h>
#include <vector>

using namespace std;

class Solution {
 public:
  bool increasingTriplet(vector<int>& nums) {
    // start with two largest values,
    // as soon as we find a number bigger than both,
    // while both have been updated, return true.
    int small = INT_MAX, big = INT_MAX;
    for (int n : nums) {
      if (n <= small) {
        // update small if n is smaller than both
        small = n;
      } else if (n <= big) {
        // update big only if greater than small but smaller than big
        big = n;
      } else {
        // return if you find a number bigger than both
        return true;
      }
    }
    return false;
  }
};
