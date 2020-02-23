#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
 public:
  vector<int> twoSum(vector<int>& nums, int target) {
    vector<int> res;
    unordered_map<int, int> m;
    for (int i = 0; i < nums.size(); i++) {
      int diff = target - nums[i];
      if (m.find(diff) != m.end()) {
        res.push_back(m[diff]);
        res.push_back(i);
        break;
      }
      m[nums[i]] = i;
    }
    return res;
  }
};
