#include <vector>
#include <set>
#include <unordered_set>

using namespace std;

class Solution {
 public:
  bool containsNearbyAlmostDuplicate(vector<int>& nums, int indexDiff, int valueDiff) {
    multiset<long long> window;
    for (int i = 0; i < nums.size(); ++i) {
      if (i > indexDiff) window.erase(nums[i - indexDiff - 1]);
      auto it = window.lower_bound((long long) nums[i] - valueDiff);
      if (it != window.end() && (long long) *it - nums[i] <= valueDiff) return true;
      window.insert(nums[i]);
    }
    return false;
  }

  bool containsNearbyAlmostDuplicate2(vector<int>& nums, int indexDiff, int valueDiff) {
    unordered_set<long> s;
    if (indexDiff >= nums.size()) {
      indexDiff = nums.size() - 1;
    }
    for(int i = 0; i < nums.size(); i ++) {
      if (valueDiff < indexDiff) {
        for(int j = nums[i] - valueDiff; j <= nums[i] + valueDiff; j ++ ) {
          if (s.count(j)) return true;
        }
      } else {
        for(auto it = s.begin(); it != s.end(); it++) {
          if (abs(*it - nums[i]) <= valueDiff) {
            return true;
          }
        }
      }
            
      s.insert(nums[i]);
      if (s.size() > indexDiff) {
        s.erase(nums[i - indexDiff]);
      }
    }
    return false;
  }
};
