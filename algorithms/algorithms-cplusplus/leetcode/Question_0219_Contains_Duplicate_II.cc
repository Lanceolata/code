#include <vector>
#include <unordered_set>

using namespace std;

class Solution {
 public:
  bool containsNearbyDuplicate(vector<int>& nums, int k) {
    std::unordered_set<int> s;
    for (int i = 0; i < nums.size(); i++) {
      if (i > k) {
        s.erase(nums[i - k - 1]);
      }
      if (!s.insert(nums[i]).second) {
        return true;
      }
    }
    return false;
  }
};
