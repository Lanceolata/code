#include <vector>

using namespace std;

class Solution {
 public:
  vector<int> searchRange(vector<int>& nums, int target) {
    vector<int> res = {-1, -1};
	  int left = searchLeft(nums, target);
    if (left < 0) {
      return res;
    }
    int right = searchRight(nums, target);
    res[0] = left;
    res[1] = right;
    return res;
  }

  int searchLeft(vector<int>& nums, int target) {
    int l = 0, r = nums.size() - 1, m;
    while (l <= r) {
      m = l + (r - l) / 2;
      if (nums[m] >= target) {
        r = m - 1;
      } else {
        l = m + 1;
      }
    }
    if (l < nums.size() && nums[l] == target) {
      return l;
    }
    return -1;
  }
  
  int searchRight(vector<int>& nums, int target) {
    int l = 0, r = nums.size() - 1, m;
    while (l <= r) {
      m = l + (r - l) / 2;
      if (nums[m] > target) {
        r = m - 1;
      } else {
        l = m + 1;
      }
    }
    if (r >= 0 && nums[r] == target) {
      return r;
    }
    return -1;
  }
};
