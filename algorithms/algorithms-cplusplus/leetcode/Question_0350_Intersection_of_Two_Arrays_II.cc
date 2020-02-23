#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
 public:
  vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
    vector<int> res;
    sort(nums1.begin(), nums1.end());
    sort(nums2.begin(), nums2.end());
    int i = 0, j = 0;
    while (i < nums1.size() && j < nums2.size()) {
      if (nums1[i] == nums2[j]) {
        res.push_back(nums1[i]);
        i++; j++;
      } else if (nums1[i] < nums2[j]) {
        i++;
      } else {
        j++;
      }
    }
    return res;
  }

  vector<int> intersect_map(vector<int>& nums1, vector<int>& nums2) {
    unordered_map<int, int> count;
    vector<int> res;
    for (size_t i = 0; i < nums1.size(); i++) {
      count[nums1[i]]++;
    }
    for (size_t i = 0; i < nums2.size(); i++) {
      if (count.find(nums2[i]) != count.end() && count[nums2[i]]-- > 0) {
        res.push_back(nums2[i]);
      }
    }
    return res;
  }
};
