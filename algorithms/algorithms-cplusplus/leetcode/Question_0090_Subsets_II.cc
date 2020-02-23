#include <vector>
#include <algorithm>

using namespace std;

class Solution {
 public:
  vector<vector<int>> subsetsWithDup(vector<int>& nums) {
    if (nums.empty()) {
      return vector<vector<int>>();
    }
    vector<vector<int>> res(1);
    sort(nums.begin(), nums.end());
    int pre = nums[0], size = 1;
    for (int i = 0; i < nums.size(); i++) {
      if (pre != nums[i]) {
        pre = nums[i];
        size = res.size();
      }
      int newSize = res.size();
      for (int j = newSize - size; j < newSize; j++) {
        vector<int> tmp = res[j];
        tmp.push_back(nums[i]);
        res.push_back(tmp);
      }
    }
    return res;
  }
};
