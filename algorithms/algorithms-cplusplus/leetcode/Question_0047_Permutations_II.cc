#include <vector>
#include <set>

using namespace std;

class Solution {
public:
  vector<vector<int>> permuteUnique(vector<int>& nums) {
    vector<vector<int>> res;
    if (nums.empty()) {
      return res;
    }
    help(nums, 0, res);
    return res;
  }

  void help(vector<int>& nums, int i, vector<vector<int>>& res) {
    if (i >= nums.size()) {
      res.push_back(nums);
      return;
    }
    set<int> s;
    for (int j = i; j < nums.size(); j++) {
      if (s.insert(nums[j]).second) {
        swap(nums[i], nums[j]);
        help(nums, i + 1, res);
        swap(nums[i], nums[j]);
      }
    }
  }
};
