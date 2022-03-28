#include <vector>
#include <unordered_set>
#include <queue>

using namespace std;

class Solution {
 public:
  bool canVisitAllRooms(vector<vector<int>>& rooms) {
    unordered_set<int> visited;
    visited.insert(0);
    queue<int> keys;
    for (int room : rooms[0]) {
      keys.push(room);
    }
    while (!keys.empty()) {
      int k = keys.front();
      keys.pop();
      if (visited.count(k)) {
        continue;
      }
      visited.insert(k);
      for (int room : rooms[k]) {
        keys.push(room);
      }
    }
    return visited.size() == rooms.size();
  }
};
