#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
 public:
  int findLHS(vector<int>& nums) {
    if (nums.empty()) {
      return 0;
    }
    unordered_map<int, int> m;
    for (int num : nums) {
      m[num] += 1;
    }
    int res = 0;
    for (auto it = m.begin(); it != m.end(); it++) {
      if (m.count(it->first + 1) != 0) {
        res = max(res, it->second + m[it->first + 1]);
      }
    }
    return res;
  }
};
