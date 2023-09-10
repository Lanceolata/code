#include <vector>

using namespace std;

class Solution {
 public:
  bool canThreePartsEqualSum(vector<int>& arr) {
    int sum = 0;
    for (int i : arr) {
      sum += i;
    }
    if (sum % 3 != 0) {
      return false;
    }
    int parts = 0, v = sum / 3;
    for (int i = 0, cur = 0; i < arr.size(); i++) {
      cur += arr[i];
      if (cur == (parts + 1) * v) {
        parts++;
      }
    }
    return parts >= 3;
  }
};
