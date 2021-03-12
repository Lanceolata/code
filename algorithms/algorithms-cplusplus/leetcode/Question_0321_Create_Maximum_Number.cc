#include <vector>

using namespace std;

class Solution {
 public:
  vector<int> maxNumber(vector<int>& nums1, vector<int>& nums2, int k) {
    int n1 = nums1.size(), n2 = nums2.size();
    vector<int> res;
    for (int i = max(0, k - n2); i <= min(k, n1); ++i) {
      res = max(res, mergeVector(maxVector(nums1, i), maxVector(nums2, k - i)));
    }
    return res;
  }

  vector<int> maxVector(vector<int>& nums, int k) {
    int drop = (int)nums.size() - k;
    vector<int> res;
    for (int i = 0; i < nums.size(); i++) {
      while (drop > 0 && !res.empty() && res.back() < nums[i]) {
        res.pop_back();
        --drop;
      }
      res.push_back(nums[i]);
    }
    res.resize(k);
    return res;
  }

  vector<int> mergeVector(vector<int> nums1, vector<int> nums2) {
    vector<int> res;
    while (!nums1.empty() || !nums2.empty()) {
      vector<int> &tmp = (nums1 > nums2) ? nums1 : nums2;
      res.push_back(tmp[0]);
      tmp.erase(tmp.begin());
    }
    return res;
  }
};