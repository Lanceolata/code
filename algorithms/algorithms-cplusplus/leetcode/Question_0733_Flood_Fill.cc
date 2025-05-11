#include <vector>

using namespace std;

class Solution {
 public:
  vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
    int m = image.size(), n = image[0].size();
    vector<vector<bool>> visited(m, vector<bool>(n, false));
    help(image, sr, sc, color, image[sr][sc], visited);
    return image;
  }

 private:
  void help(vector<vector<int>>& image, int r, int c, int color, int v, vector<vector<bool>>& visited) {
    if (r < 0 || r >= image.size() || c < 0 || c >= image[0].size()) {
      return;
    }
    if (image[r][c] != v || visited[r][c]) {
      return;
    }
    visited[r][c] = true;
    image[r][c] = color;
    help(image, r - 1, c, color, v, visited);
    help(image, r + 1, c, color, v, visited);
    help(image, r, c - 1, color, v, visited);
    help(image, r, c + 1, color, v, visited);
  }
};
