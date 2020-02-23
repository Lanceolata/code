#include <vector>
#include <unordered_set>

using namespace std;

class Solution {
 public:
  int longestConsecutive(vector<int>& nums) {
    if (nums.size() <= 1) {
      return nums.size();
    }
    unordered_set<long> s(nums.begin(), nums.end());
    int res = 0, cnt = 0;
    for (long n : nums) {
      if (!s.count(n - 1)) {
        cnt = 0;
        while (s.count(n++)) {
          cnt++;
        }
        res = max(res, cnt);
      }
    }
    return res;
  }
};
