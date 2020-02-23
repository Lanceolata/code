#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  string originalDigits(string s) {
    string res = "";
    vector<int> counts(128, 0), nums(10, 0);
    for (char c : s) {
      ++counts[c];
    }
    nums[0] = counts['z'];
    nums[2] = counts['w'];
    nums[4] = counts['u'];
    nums[6] = counts['x'];
    nums[8] = counts['g'];
    nums[1] = counts['o'] - nums[0] - nums[2] - nums[4];
    nums[3] = counts['h'] - nums[8];
    nums[5] = counts['f'] - nums[4];
    nums[7] = counts['s'] - nums[6];
    nums[9] = counts['i'] - nums[6] - nums[8] - nums[5];
    for (int i = 0; i < nums.size(); ++i) {
      for (int j = 0; j < nums[i]; ++j) {
        res += (i + '0');
      }
    }
    return res;
  }

  string originalDigits2(string s) {
    string res = "";
    vector<string> words{"zero", "two", "four", "six", "eight", "one", "three", "five", "seven", "nine"};
    vector<int> nums{0, 2, 4, 6, 8, 1, 3, 5, 7, 9}, counts(26, 0);
    vector<char> chars{'z', 'w', 'u', 'x', 'g', 'o', 'h', 'f', 's', 'i'};
    for (char c : s) {
      ++counts[c - 'a'];
    }
    for (int i = 0; i < 10; ++i) {
      int cnt = counts[chars[i] - 'a'];
      for (int j = 0; j < words[i].size(); ++j) {
        counts[words[i][j] - 'a'] -= cnt;
      }
      while (cnt--) res += (nums[i] + '0');
    }
    sort(res.begin(), res.end());
    return res;
  }
};
