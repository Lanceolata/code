#include <vector>
#include <set>

using namespace std;

class Solution {
 public:
  vector<int> advantageCount(vector<int>& nums1, vector<int>& nums2) {
    multiset<int> s(nums1.begin(), nums1.end());
    for (int i = 0; i < nums2.size(); ++i) {
      auto it = *s.rbegin() > nums2[i] ? s.upper_bound(nums2[i]) : s.begin();
      nums1[i] = *it;
      s.erase(it);
    }
    return nums1;
  }
};
