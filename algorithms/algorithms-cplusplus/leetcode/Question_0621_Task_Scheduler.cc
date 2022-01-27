#include <vector>

using namespace std;

class Solution {
 public:
  int leastInterval(vector<char>& tasks, int n) {
    vector<int> vec(256);
    int count = 0;
    for(char c : tasks) {
      vec[c]++;
      count = max(count, vec[c]);
    }
    int res = (count - 1) * (n + 1);
    for (int i : vec) {
      if (i == count) {
        res++;
      }
    }
    return max((int) tasks.size(), res);
  }
};
