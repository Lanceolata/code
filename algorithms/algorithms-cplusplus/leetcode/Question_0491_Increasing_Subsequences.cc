#include <vector>
#include <unordered_set>

using namespace std;

class Solution {
 public:
  vector<vector<int>> findSubsequences(vector<int>& nums) {
    vector<vector<int>> res;
    vector<int> vec;
    help(nums, 0, vec, res);
    return res;
  }

  void help(vector<int>& nums, int i, vector<int>& vec, vector<vector<int>>& res) {
    if (vec.size() >= 2) {
      res.push_back(vec);
    }
    unordered_set<int> st;
    for (int j = i; j < nums.size(); j++) {
      if ((!vec.empty() && vec.back() > nums[j]) || st.count(nums[j])) {
        continue;
      }
      vec.push_back(nums[j]);
      st.insert(nums[j]);
      help(nums, j + 1, vec, res);
      vec.pop_back();
    }
  }
};
