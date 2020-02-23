#include <vector>

using namespace std;

class Solution {
 public:
  vector<vector<int>> subsets(vector<int>& nums) {
    vector<vector<int>> res;
    res.push_back({});
    for (int n : nums) {
      size_t size = res.size();
      for (int i = 0; i < size; i++) {
        vector<int> vec = res[i];
        vec.push_back(n);
        res.push_back(vec);
      }
    }
    return res;
  }

  vector<vector<int>> subsets_dfs(vector<int>& nums) {
    vector<vector<int>> res;
    vector<int> vec;
    help(res, vec, nums, 0);
    return res;
  }

  void help(vector<vector<int>>& res, vector<int>& vec, vector<int>& nums, int index) {
    res.push_back(vec);
    for (int i = index; i < nums.size(); i++) {
      vec.push_back(nums[i]);
      help(res, vec, nums, i + 1);
      vec.pop_back();
    }
  }
};
