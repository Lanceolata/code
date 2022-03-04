#include <vector>

using namespace std;

class Solution {
 public:
  int minCostClimbingStairs(vector<int>& cost) {
    int s1 = 0, s2 = 0, t;
    for (int c : cost) {
      t = min(s1, s2) + c;
      s2 = s1;
      s1 = t;
    }
    return min(s1, s2);
  }
};
