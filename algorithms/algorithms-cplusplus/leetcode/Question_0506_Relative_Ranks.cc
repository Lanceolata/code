#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
 public:
  vector<string> findRelativeRanks(vector<int>& score) {
    vector<string> res;
    if (score.size() == 0) {
      return res;
    }
    vector<int> nums(score.begin(), score.end());
    sort(nums.rbegin(), nums.rend());
    unordered_map<int, int> m;
    for (int i = 0; i < nums.size(); i++) {
      m[nums[i]] = i;
    }
    for (int i = 0; i < score.size(); i++) {
      int index = m[score[i]];
      if (index == 0) {
        res.push_back("Gold Medal");
      } else if (index == 1) {
        res.push_back("Silver Medal");
      } else if (index == 2) {
        res.push_back("Bronze Medal");
      } else {
        res.push_back(to_string(index + 1));
      }
    }
    return res;
  }
};
