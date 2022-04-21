#include <vector>
#include <unordered_set>

using namespace std;

class Solution {
 public:
  int subarrayBitwiseORs(vector<int>& arr) {
    vector<int> vec;
    for (int i = 0, st = 0, en = 0; i < arr.size(); ++i, st = en, en = vec.size()) {
      vec.push_back(arr[i]);
      for (int j = st; j < en; ++j) {
        if (vec.back() != (vec[j] | arr[i])) {
          vec.push_back(vec[j] | arr[i]);
        }
      }
    }
    return unordered_set<int>(vec.begin(), vec.end()).size();
  }
};
