#include <vector>

using namespace std;

class Solution {
 public:
  int arrayNesting(vector<int>& nums) {
    int n = nums.size(), res = 0;
    for (int i = 0; i < n; ++i) {
      int cnt = 0, cur = i, next;
      while (nums[cur] != n) {
        cnt++;
        next = nums[cur];
        nums[cur] = n;
        cur = next;
      }
      res = max(res, cnt);
    }
    return res;
  }
};
