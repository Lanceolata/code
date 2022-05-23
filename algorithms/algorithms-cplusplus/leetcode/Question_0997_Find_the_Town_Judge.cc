#include <vector>

using namespace std;

class Solution {
 public:
  int findJudge(int n, vector<vector<int>>& trust) {
    vector<int> v1(n, 0), v2(n, 0);
    for (vector<int>& t : trust) {
      v1[t[0] - 1]++;
      v2[t[1] - 1]++;
    }
    for (int i = 0; i < n; i++) {
      if (v1[i] == 0 && v2[i] == n - 1) {
        return i + 1;
      }
    }
    return -1;
  }
};
