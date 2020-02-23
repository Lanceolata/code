#include <vector>

using namespace std;

class Solution {
 public:
  vector<int> FindNumbersWithSum(vector<int> array,int sum) {
    vector<int> res;
    if (array.empty()) {
      return res;
    }
    int l = 0, r = array.size() - 1;
    while (l < r) {
      int n = array[l] + array[r];
      if (n == sum) {
        res.push_back(array[l]);
        res.push_back(array[r]);
        break;
      } else if (n < sum) {
        l++;
      } else {
        r--;
      }
    }
    return res;
  }
};
