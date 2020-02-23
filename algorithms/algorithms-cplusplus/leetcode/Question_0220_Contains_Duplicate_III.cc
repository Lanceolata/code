#include <vector>
#include <set>
#include <unordered_set>

using namespace std;

class Solution {
 public:
  bool containsNearbyAlmostDuplicate(vector<int>& nums, int k, int t) {
    multiset<long long> window;
    for (int i = 0; i < nums.size(); ++i) {
      if (i > k) window.erase(nums[i - k - 1]);
      auto it = window.lower_bound((long long) nums[i] - t);
      if (it != window.end() && (long long) *it - nums[i] <= t) return true;
      window.insert(nums[i]);
    }
    return false;
  }

  bool containsNearbyAlmostDuplicate2(vector<int>& nums, int k, int t) {
    unordered_set<long> s;
    if (k >= nums.size()) {
      k = nums.size() - 1;
    }
    for(int i = 0; i < nums.size(); i ++) {
      if (t < k) {
        for(int j = nums[i] - t; j <= nums[i] + t; j ++ ) {
          if (s.count(j)) return true;
        }
      } else {
        for(auto it = s.begin(); it != s.end(); it++) {
          if (abs(*it - nums[i]) <= t) {
            return true;
          }
        }
      }
            
      s.insert(nums[i]);
      if (s.size() > k) {
        s.erase(nums[i - k]);
      }
    }
    return false;
  }
};
