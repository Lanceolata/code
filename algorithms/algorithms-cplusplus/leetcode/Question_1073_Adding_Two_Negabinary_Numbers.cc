#include <vector>

using namespace std;

class Solution {
 public:
  vector<int> addNegabinary(vector<int>& arr1, vector<int>& arr2) {
    vector<int> res;
    int carry = 0, i = arr1.size() - 1, j = arr2.size() - 1;
    while (i >= 0 || j >= 0 || carry) {
      carry += i >= 0 ? arr1[i--] : 0;
      carry += j >= 0 ? arr2[j--] : 0;
      res.push_back(carry & 1);
      carry = -(carry >> 1);
    }
    while (res.size() > 1 && res.back() == 0) {
      res.pop_back();
    }
    reverse(res.begin(), res.end());
    return res;
  }
};
