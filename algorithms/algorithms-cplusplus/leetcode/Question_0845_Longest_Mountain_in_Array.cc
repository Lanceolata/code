#include <vector>

using namespace std;

class Solution {
 public:
  int longestMountain(vector<int>& arr) {
    int n = arr.size(), res = 0;
    for (int i = 0; i < n; ) {
      int j = i;
      while (j + 1 < n && arr[j] < arr[j + 1]) {
        j++;
      }
      int k = j;
      while (j != i && j + 1 < n && arr[j] > arr[j + 1]) {
        j++;
      }
      if (j != i && j != k) {
        res = max(res, j - i + 1);
      }
      i = max(i + 1, j);
    }
    return res;
  }
};
