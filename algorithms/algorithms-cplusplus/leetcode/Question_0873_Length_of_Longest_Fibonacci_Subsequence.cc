#include <vector>
#include <unordered_set>

using namespace std;

class Solution {
 public:
  int lenLongestFibSubseq(vector<int>& arr) {
    unordered_set<int> s(arr.begin(), arr.end());
    int res = 0;
    for (int i = 0; i < arr.size(); ++i) {
      for (int j = i + 1; j < arr.size(); ++j) {
        int  a = arr[i], b = arr[j], l = 2;
        while (s.count(a + b)) {
          b = a + b;
          a = b - a;
          l++;
        }
        res = max(res, l);
      }
    }
    return res > 2 ? res : 0;
  }
};
