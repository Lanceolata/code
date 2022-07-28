#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
 public:
  Solution(vector<int> nums) {
    for (int i = 0; i < nums.size(); i++) {
      m[nums[i]].push_back(i);
    }
  }

  int pick(int target) {
    int index = rand() % m[target].size();
    return m[target][index];
  }

 private:
  unordered_map<int, vector<int>> m;
};
