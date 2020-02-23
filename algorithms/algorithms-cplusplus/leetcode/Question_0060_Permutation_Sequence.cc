#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  string getPermutation(int n, int k) {
    vector<int> nums(n);
    int cnt = 1;
    for (int i = 0; i < n; i++) {
      nums[i] = i + 1;
      cnt *= i + 1;
    }
    k--;
    string res = "";
    for (int i = 0; i < n; i++) {
      cnt /= n - i;
      int select = k / cnt;
      res += '0' + nums[select];
      for (int j = select; j < n - i - 1; j++) {
        nums[j] = nums[j + 1];
      }
      k = k % cnt;
    }
    return res;
  }
};
