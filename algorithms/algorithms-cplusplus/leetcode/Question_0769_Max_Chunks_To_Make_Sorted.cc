#include <vector>

using namespace std;

class Solution {
 public:
  int maxChunksToSorted(vector<int>& arr) {
    int res = 0, maxI = 0;
    for (int i = 0; i < arr.size(); i++) {
      maxI = max(maxI, arr[i]);
      if (maxI == i) {
        ++res;
      }
    }
    return res;
  }
};
