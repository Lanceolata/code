#include <vector>

using namespace std;

class Solution {
 public:
  int maxTurbulenceSize(vector<int>& arr) {
    int res = 0, cur = 0;
    for(int i = 0; i < arr.size(); ++i) {
      if (i >= 2 && ((arr[i - 2] > arr[i - 1] && arr[i - 1] < arr[i]) ||
          (arr[i - 2] < arr[i - 1] && arr[i - 1] > arr[i])) ) {
        cur++;
      } else if (i >= 1 && arr[i - 1] != arr[i]) {
        cur = 2;
      } else {
        cur = 1;
      }
      res = max(res, cur);
    }
    return res;
  }
};
