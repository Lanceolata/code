#include <vector>

using namespace std;

class Solution {
 public:
  Solution(vector<int>& w) {
    sum = vector<int>(w.size(), 0);
    sum[0] = w[0];
    for (int i = 1; i < w.size(); ++i) {
      sum[i] = sum[i - 1] + w[i];
    }
  }

  int pickIndex() {
    int x = rand() % sum.back(), left = 0, right = sum.size() - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (sum[mid] <= x) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return right;
  }
 private:
  vector<int> sum;
};
