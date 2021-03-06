#include <vector>

using namespace std;

class Solution {
 public:
  int countRangeSum(vector<int>& nums, int lower, int upper) {
    if (nums.empty()) {
      return 0;
    }
    vector<long> sums(nums.size() + 1, 0);
    for (int i = 1; i < sums.size(); i++) {
      sums[i] = sums[i - 1] + nums[i - 1];
    }
    return countAndMergeSort(sums, 0, sums.size(), lower, upper);
  }

  int countAndMergeSort(vector<long> &sums, int start, int end, int lower, int upper) {
    if (end - start <= 1) return 0;
    int mid = start + (end - start) / 2;
    int cnt = countAndMergeSort(sums, start, mid, lower, upper) + countAndMergeSort(sums, mid, end, lower, upper);
    int j = mid, k = mid, t = mid;
    vector<int> cache(end - start, 0);
    for (int i = start, r = 0; i < mid; ++i, ++r) {
      while (k < end && sums[k] - sums[i] < lower) ++k;
      while (j < end && sums[j] - sums[i] <= upper) ++j;
      while (t < end && sums[t] < sums[i]) cache[r++] = sums[t++];
      cache[r] = sums[i];
      cnt += j - k;
    }
    copy(cache.begin(), cache.begin() + t - start, sums.begin() + start);
    return cnt;
  }
};
