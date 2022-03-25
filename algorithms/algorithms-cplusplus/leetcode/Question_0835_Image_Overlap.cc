#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
 public:
  int largestOverlap(vector<vector<int>>& img1, vector<vector<int>>& img2) {
    vector<int> l1, l2;
    int n = img1.size();
    unordered_map<int, int> count;
    for (int i = 0; i < n * n; ++i) {
      if (img1[i / n][i % n] == 1) {
        l1.push_back(i / n * 100 + i % n);
      }
    }
    for (int i = 0; i < n * n; ++i) {
      if (img2[i / n][i % n] == 1) {
        l2.push_back(i / n * 100 + i % n);
      }
    }
    for (int i : l1) {
      for (int j : l2) {
        count[i - j]++;
      }
    }
    int res = 0;
    for (auto it : count) {
      res = max(res, it.second);
    }
    return res;
  }
};
