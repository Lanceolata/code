#include <string>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
 public:
  static bool compare(string a, string b){
    return a + b < b + a;
  }

  string largestNumber(vector<int>& nums) {
    if (nums.empty()) {
      return "";
    }
    vector<string> num_str;
    for (size_t i = 0; i < nums.size(); i++){
      num_str.push_back(to_string(nums[i]));
    }
    sort(num_str.begin(), num_str.end(), compare);
    string res="";
    for (int i = nums.size() - 1; i >= 0; i--) {
      res += num_str[i];
    }
    if (res[0] == '0') {
      return "0";
    }
    return res;
  }
};
