#include <vector>

using namespace std;

class Solution {
 public:
  vector<int> GetLeastNumbers_Solution(vector<int> input, int k) {
    vector<int> res;
    if (input.empty() || k <= 0 || k > input.size()) {
      return res;
    }
    // 构建长度为k的大根堆
    for(int i = input.size() / 2 - 1; i >= 0; i--) {
      sink(input, i, k);
    }
    for (int i = k; i < input.size();) {
      if (input[i] < input[0]) {
        swap(input[0], input[i]);
        sink(input, 0, k);
      } else {
        i++;
      }
    }
    for (int i = 0; i < k; i++) {
      res.push_back(input[i]);
    }
    return res;
  }

  void sink(vector<int>& nums, int i, int n) {
    while (2 * i + 1 < n) {
      int j = 2 * i + 1;
      if (j + 1 < n && nums[j] < nums[j + 1]) {
        j++;
      }
      if (nums[i] > nums[j]) {
        break;
      }
      swap(nums[i], nums[j]);
      i = j;
    }
  }
};
