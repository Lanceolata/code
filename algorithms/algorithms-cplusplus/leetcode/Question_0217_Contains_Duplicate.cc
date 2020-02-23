#include <vector>
#include <set>

using namespace std;

class Solution {
 public:
  bool containsDuplicate(vector<int>& nums) {
    std::set<int> s;
    for (size_t i = 0; i < nums.size(); i++) {
      if (!s.insert(nums[i]).second) {
        return true;
      }
    }
    return false;
  }
};
