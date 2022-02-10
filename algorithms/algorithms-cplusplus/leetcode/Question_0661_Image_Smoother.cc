#include <vector>

using namespace std;

class Solution {
 public:
  vector<vector<int>> imageSmoother(vector<vector<int>>& img) {
    int m = img.size(), n = img[0].size();
    vector<vector<int>> res(m, vector<int>(n, 0));
    vector<int> ms = {-1, 0, 1};
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int sum = 0, cnt = 0;
        for (int x : ms) {
          for (int y : ms) {
            if (i + x < 0 || i + x >= m || j + y < 0 || j + y >= n) {
              continue;
            }
            cnt++;
            sum += img[i + x][j + y];
          }
        }
        res[i][j] = sum / cnt;
      }
    }
    return res;
  }
};
