#include <vector>

using namespace std;

class Solution {
 public:
  vector<vector<int>> FindContinuousSequence(int sum) {
    vector<vector<int>> res;
    if (sum <= 0) {
      return res;
    }
    int l = 1, r = 2; 
    while (l < r) {
      int cur = (l + r) * (r - l + 1) / 2;
      if (cur == sum) {
        vector<int> vec;
        for (int i = l; i <= r; i++) {
          vec.push_back(i);
        }
        res.push_back(vec);
        l++;
      } else if (cur < sum) {
        r++;
      } else {
        l++;
      }
    }
    return res;
  }
};
