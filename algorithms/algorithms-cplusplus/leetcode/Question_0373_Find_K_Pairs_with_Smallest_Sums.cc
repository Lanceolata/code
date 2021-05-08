#include <vector>
#include <queue>

using namespace std;

class Solution {
 public:
  vector<vector<int>> kSmallestPairs(vector<int>& nums1, vector<int>& nums2, int k) {
    vector<vector<int>> res;
    if (nums1.empty() || nums2.empty() || k <= 0) {
      return res;
    }
    auto comp = [](vector<int> a, vector<int> b) {
        return a[0] + a[1] > b[0] + b[1];
    };
    priority_queue<vector<int>, vector<vector<int>>, decltype(comp)> q(comp);
    for (int i = 0; i < nums1.size(); i++) {
      q.emplace(vector<int>{nums1[i], nums2[0], 0});
    }
    while (k-- > 0 && !q.empty()) {
      vector<int> vec = q.top();
      q.pop();
      res.push_back({vec[0], vec[1]});
      if (vec[2] == nums2.size() - 1) {
          continue;
      }
      q.emplace(vector<int>{vec[0], nums2[vec[2] + 1], vec[2] + 1});
    }
    return res;
  }
};
