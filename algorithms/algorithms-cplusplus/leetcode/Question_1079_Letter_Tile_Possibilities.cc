#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  int numTilePossibilities(string tiles) {
    vector<int> count(26, 0);
    for (char c : tiles) {
      count[c - 'A']++;
    }
    return dfs(count);
  }

  int dfs(vector<int>& arr) {
    int sum = 0;
    for (int i = 0; i < 26; i++) {
      if (arr[i] == 0) {
        continue;
      }
      sum++;
      arr[i]--;
      sum += dfs(arr);
      arr[i]++;
    }
    return sum;
  }
};
