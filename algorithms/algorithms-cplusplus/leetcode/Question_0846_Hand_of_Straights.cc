#include <vector>
#include <map>

using namespace std;

class Solution {
 public:
  bool isNStraightHand(vector<int>& hand, int groupSize) {
    map<int, int> m;
    for (int i : hand) {
      m[i]++;
    }
    for (auto it : m) {
      if (it.second > 0) {
        for (int i = groupSize - 1; i >= 0; --i) {
          if ((m[it.first + i] -= it.second) < 0) {
            return false;
          }
        }
      }
    }
    return true;
  }
};
