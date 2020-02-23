#include <vector>

using namespace std;

class Solution {
 public:
  int majorityElement(vector<int>& nums) {
    int num = nums[0], count = 0;
    for (int n : nums) {
      if (count == 0) {
        count = 1;
        num = n;
      }else if (n == num) {
        count++;
      } else {
        count--;
      }
    }
    count = 0;
    for (int i : nums) {
      if (i == num) {
        count++;
      }
    }
    return (count <= nums.size() / 2) ? -1 : num;
  }
};
