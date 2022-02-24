#include <vector>

using namespace std;

class Solution {
 public:
  bool canPartitionKSubsets(vector<int>& nums, int k) {
    int sum = 0;
    for (int i : nums) {
      sum += i;
    }
    if (sum % k != 0) {
      return false;
    }
    vector<bool> visited(nums.size(), false);
    sort(nums.begin(),nums.end());
    return help(nums, k, sum / k, 0, 0, visited);
  }

  bool help(vector<int>& nums, int k, int target, int cur, int index, vector<bool>& visited) {
    if (k == 1) {
      return true;
    }
    if (cur == target) {
      return help(nums, k - 1, target, 0, 0, visited);
    }
    for (int i = index; i < nums.size(); i++) {
      if (visited[i] || cur + nums[i] > target) {
        continue;
      }
      visited[i] = true;
      if (help(nums, k, target, cur + nums[i], i + 1, visited)) {
        return true;
      }
      visited[i] = false;
      while(i + 1 < nums.size() && nums[i] == nums[i + 1]) {
        i++;
      }
    }
    return false;
  }
};
