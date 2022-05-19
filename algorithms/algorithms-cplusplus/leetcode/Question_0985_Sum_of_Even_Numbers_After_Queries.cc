#include <vector>

using namespace std;

class Solution {
 public:
  vector<int> sumEvenAfterQueries(vector<int>& nums, vector<vector<int>>& queries) {
    vector<int> res;
    int sum = 0;
    for (int n : nums) {
      if ((n & 1) == 0) {
        sum += n;
      }
    }
    for (vector<int>& q : queries) {
      int i = q[1], v = q[0];
      if ((nums[i] & 1) == 0) {
        sum -= nums[i];
      }
      nums[i] += v;
      if ((nums[i] & 1) == 0) {
        sum += nums[i];
      }
      res.push_back(sum);
    }
    return res;
  }
};
