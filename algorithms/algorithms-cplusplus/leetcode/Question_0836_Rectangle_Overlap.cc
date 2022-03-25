#include <vector>

using namespace std;

class Solution {
 public:
  bool isRectangleOverlap(vector<int>& rec1, vector<int>& rec2) {
    bool up = rec1[1] >= rec2[3];
    bool down = rec1[3] <= rec2[1];
    bool left = rec1[2] <= rec2[0];
    bool right = rec1[0] >= rec2[2];
    return !(up || down || left || right);
  }
};
