#include <vector>

using namespace std;

class Solution {
 public:
  vector<bool> prefixesDivBy5(vector<int>& nums) {
    vector<bool> res;
    int cur = 0;
    for (int n : nums) {
      cur = cur * 2 % 5 + n;
      res.push_back(cur % 5 == 0);
    }
    return res;
  }
};
