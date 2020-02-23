#include <vector>

using namespace std;

class Solution {
 public:
  int hIndex(vector<int>& citations) {
    int n = citations.size(), l = 0, r = citations.size() - 1, m;
    while (l <= r) {
      int m = l + (r - l) / 2;
      if (citations[m] == n - m) {
        return n - m;
      } else if (citations[m] > n - m) {
        r = m - 1;
      } else {
        l = m + 1;
      }
    }
    return n - l;
  }
};
