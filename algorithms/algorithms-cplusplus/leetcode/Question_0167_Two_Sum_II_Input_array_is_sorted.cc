#include <vector>

using namespace std;

class Solution {
 public:
  vector<int> twoSum(vector<int>& numbers, int target) {
    vector<int> res;
    int l = 0, r = numbers.size() - 1;
    while (l < r) {
      int num = numbers[l] + numbers[r];
      if (num == target) {
        res.push_back(l + 1);
        res.push_back(r + 1);
        break;
      } else if (num < target) {
        l++;
      } else {
        r--;
      }
    }
    return res;
  }
};
