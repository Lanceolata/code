#include <vector>

using namespace std;

class Solution {
public:
  vector<vector<int>> permute(vector<int>& nums) {
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
    for (int j = i; j < nums.size(); j++) {
      swap(nums[i], nums[j]);
      help(nums, i + 1, res);
      swap(nums[i], nums[j]);
    }
  }
};
