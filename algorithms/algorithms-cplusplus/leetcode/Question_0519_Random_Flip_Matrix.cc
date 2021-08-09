#include <vector>
#include <unordered_set>

using namespace std;

class Solution {
 public:
  Solution(int m, int n) {
    row = m;
    col = n;
    size = row * col;
  }
    
  vector<int> flip() {
    while (true) {
      int val = rand() % (row * col);
      if (!flipped.count(val)) {
        flipped.insert(val);
        return {val / col, val % col};
      }
    }
  }
    
  void reset() {
    flipped.clear();
  }

 private:
  int row, col, size;
  unordered_set<int> flipped;
};
