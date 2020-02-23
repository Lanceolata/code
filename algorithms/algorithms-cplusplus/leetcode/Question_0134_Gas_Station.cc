#include <vector>

using namespace std;

class Solution {
 public:
  int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
    if (gas.empty() || cost.empty() || gas.size() != cost.size()) {
      return -1;
    }
    int total = 0, sum = 0, index = -1;
    for (int i = 0; i < gas.size(); i++) {
      total += gas[i] - cost[i];
      sum += gas[i] - cost[i];
      if (sum < 0) {
        sum = 0;
        index = i;
      }
    }
    return total >= 0 ? index + 1 : -1;
  }
};
