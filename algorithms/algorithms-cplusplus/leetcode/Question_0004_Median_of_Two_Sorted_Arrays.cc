#include <limits.h>
#include <vector>

using namespace std;

class Solution {
 public:
  double findMedianSortedArrays_recursion(vector<int>& nums1, vector<int>& nums2) {
    int m = nums1.size(), n = nums2.size();
    if (((m + n) & 1) == 1) {
      return findKth(nums1, 0, nums2, 0, (m + n + 1) / 2);
    } else {
      return (findKth(nums1, 0, nums2, 0, (m + n + 1) / 2) + findKth(nums1, 0, nums2, 0, (m + n + 2) / 2)) / 2.0;
    }
  }

  int findKth(vector<int>& nums1, int i, vector<int>& nums2, int j, int k) {
    if (i >= nums1.size()) {
      return nums2[j + k - 1];
    } else if (j >= nums2.size()) {
      return nums1[i + k - 1];
    } else if (k == 1) {
      return min(nums1[i], nums2[j]);
    }
    int midVal1 = (i + k / 2 - 1 < nums1.size()) ? nums1[i + k / 2 - 1] : INT_MAX;
    int midVal2 = (j + k / 2 - 1 < nums2.size()) ? nums2[j + k / 2 - 1] : INT_MAX;
    if (midVal1 < midVal2) {
      return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
    } else {
      return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
    }
  }
};
