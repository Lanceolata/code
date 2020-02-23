#include <vector>
#include <set>
#include <unordered_map>

using namespace std;

class Solution {
 public:
  vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
    vector<int> res;
    sort(nums1.begin(), nums1.end());
    sort(nums2.begin(), nums2.end());
    int i = 0, j = 0;
    while (i < nums1.size() && j < nums2.size()) {
      if (nums1[i] == nums2[j]) {
        res.push_back(nums1[i]);
        while (i < nums1.size() - 1 && nums1[i] == nums1[i + 1]) {
          i++;
        }
        while (j < nums2.size() - 1 && nums2[j] == nums2[j + 1]) {
          j++;
        }
        i++; j++;
      } else if (nums1[i] < nums2[j]) {
        i++;
      } else {
        j++;
      }
    }
    return res;
  }

  vector<int> intersection_builtin(vector<int>& nums1, vector<int>& nums2) {
    vector<int> res;
    set<int> set1(nums1.begin(), nums1.end()), set2(nums2.begin(), nums2.end());
    set_intersection(set1.begin(), set1.end(), set2.begin(), set2.end(), back_inserter(res));
    return res;
  }

  vector<int> intersection_map(vector<int>& nums1, vector<int>& nums2) {
    unordered_map<int, int> count;
    vector<int> res;
    for (size_t i = 0; i < nums1.size(); i++) {
      count[nums1[i]] = 1;
    }
    for (size_t j = 0; j < nums2.size(); j++) {
      if (count[nums2[j]] != 0) {
        res.push_back(nums2[j]);
        count[nums2[j]]--;
      }
    }
    return res;
  }
};
