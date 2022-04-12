#include <string>
#include <vector>
#include <unordered_set>

using namespace std;

class Solution {
 public:
  int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {
    unordered_set<string> obs;
    for (int i = 0; i < obstacles.size(); i++) {
      obs.insert(help(obstacles[i][0], obstacles[i][1]));
    }
    int res = 0, dir = 0, x = 0, y = 0;
    vector<vector<int>> ds = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    for (int i = 0; i < commands.size(); i++) {
      if (commands[i] == -2) {
        dir--;
      } else if (commands[i] == -1) {
        dir++;
      } else {
        for (int j = 0; j < commands[i]; j++) {
          string pos = help(x + ds[dir][0], y + ds[dir][1]);
          if (obs.count(pos)) {
            break;
          }
          x += ds[dir][0];
          y += ds[dir][1];
        }
        res = max(res, x * x + y * y);
      }
      if(dir == -1) {
        dir = 3;
      }
      if(dir == 4) {
        dir = 0;
      }
    }
    return res;
  }

 private:
  string help(int x, int y) {
    return to_string(x) + "#" + to_string(y);
  }
};
