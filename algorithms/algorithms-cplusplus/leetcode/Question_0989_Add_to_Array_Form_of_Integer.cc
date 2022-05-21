#include <vector>

using namespace std;

class Solution {
 public:
  vector<int> addToArrayForm(vector<int>& num, int k) {
    vector<int> res;
    int i = num.size() - 1, carry = 0;
    while (i >= 0 || k > 0 || carry > 0) {
      carry += (i >= 0 ? num[i--] : 0) + (k > 0 ? k % 10 : 0);
      res.push_back(carry % 10);
      carry /= 10;
      k /= 10;
    }
    reverse(res.begin(), res.end());
    return res;
  }
};
