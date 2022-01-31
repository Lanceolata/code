#include <vector>

using namespace std;

class Solution {
 public:
  int shoppingOffers(vector<int>& price, vector<vector<int>>& special, vector<int>& needs) {
    return shopping(price, special, needs);
  }

  int shopping(vector<int>& price, vector<vector<int>>& special, vector<int>& needs) {
    int i = 0, res = dot(needs, price);
    for (vector<int>& s : special) {
      vector<int> clone(needs);
      for (i = 0; i < needs.size(); i++) {
        int diff = clone[i] - s[i];
        if (diff < 0) {
          break;
        }
        clone[i] = diff;
      }
      if (i == needs.size()) {
        res = min(res, s[i] + shopping(price, special, clone));
      }
    }
    return res;
  }

  int dot(vector<int>& a, vector<int>& b) {
    int sum = 0;
    for (int i = 0; i < a.size(); i++) {
      sum += a[i] * b[i];
    }
    return sum;
  }
};
