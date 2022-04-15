#include <vector>
#include <unordered_set>

using namespace std;

class Solution {
 public:
  vector<int> fairCandySwap(vector<int>& aliceSizes, vector<int>& bobSizes) {
    int sum = 0;
    for (int i : aliceSizes) {
      sum += i;
    }
    for (int i : bobSizes) {
      sum -= i;
    }
    int delta = sum / 2;
    unordered_set<int> s(aliceSizes.begin(), aliceSizes.end());
    for (int i : bobSizes) {
      if (s.count(i + delta)) {
        return {i + delta, i};
      }
    }
    return {};
  }
};
