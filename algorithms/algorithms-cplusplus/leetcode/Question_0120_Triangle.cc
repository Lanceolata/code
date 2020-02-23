#include <vector>
#include <algorithm>

using namespace std;

class Solution {
 public:
  int minimumTotal(vector<vector<int>>& triangle) {
    if (triangle.empty()) {
      return 0;
    }
    for (int i = triangle.size() - 2; i >= 0; i--) {
      vector<int>& cur = triangle[i];
      vector<int>& sub = triangle[i + 1];
      for (size_t j = 0; j < cur.size(); j++) {
        cur[j] += min(sub[j], sub[j + 1]);
      }
    }
    return triangle[0][0];
  }
};
