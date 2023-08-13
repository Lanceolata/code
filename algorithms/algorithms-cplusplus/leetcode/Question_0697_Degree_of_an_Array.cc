#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
 public:
  int findShortestSubArray(vector<int>& nums) {
    int maxf = 0;
    unordered_map<int, int> f, l, r;
    for (int i = 0; i < nums.size(); i++) {
      f[nums[i]] += 1;
      maxf = max(maxf, f[nums[i]]);
      if (l.count(nums[i]) == 0) {
        l[nums[i]] = i;
      }
      r[nums[i]] = i;
    }
    vector<int> vec;
    for (unordered_map<int, int>::iterator it = f.begin(); it != f.end(); it++) {
      if (it->second == maxf) {
        vec.push_back(it->first);
      }
    }
    int res = nums.size();
    for (int n : vec) {
      res = min(res, r[n] - l[n] + 1);
    }
    return res;
  }
};
