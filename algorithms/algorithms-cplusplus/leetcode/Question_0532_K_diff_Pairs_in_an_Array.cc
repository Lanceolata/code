#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
 public:
  int findPairs(vector<int>& nums, int k) {
    if (nums.size() <= 1 || k < 0) {
      return 0;
    }
    unordered_map<int, int> m;
    int res = 0;
    for (int n : nums) {
      m[n] += 1;
    }
    for (unordered_map<int, int>::iterator it = m.begin(); it != m.end(); it++) {
      if (k == 0) {
        if (it->second >= 2) {
          res++;
        }
      } else {
        if (m.count(it->first + k)) {
          res++;
        }
      }
    }
    return res;
  }
};
