#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
 public:
  vector<string> findRestaurant(vector<string>& list1, vector<string>& list2) {
    vector<string> res;
    if (list1.empty() || list2.empty()) {
      return res;
    }
    unordered_map<string, int> m;
    for (int i = 0; i < list1.size(); i++) {
      m[list1[i]] = i;
    }
    int sum = list1.size() + list2.size(), tmp;
    for (int i = 0; i < list2.size() && i <= sum; i++) {
      if (m.count(list2[i]) == 0) {
        continue;
      }
      tmp = m[list2[i]] + i;
      if (tmp > sum) {
        continue;
      }
      if (tmp < sum) {
        sum = tmp;
        res.clear();
      }
      res.push_back(list2[i]);
    }
    return res;
  }
};