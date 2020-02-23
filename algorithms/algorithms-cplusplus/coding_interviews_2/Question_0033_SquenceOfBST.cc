#include <vector>

using namespace std;

class Solution {
 public:
  bool VerifySquenceOfBST(vector<int> sequence) {
    if (sequence.empty()) {
      return false;
    }
    return help(sequence, 0, sequence.size() - 1);
  }

  bool help(vector<int> sequence, int l, int h) {
    if (l >= h) {
      return true;
    }
    int root = sequence[h];
    int i = l;
    for (; i < h; i++) {
      if (sequence[i] > root) {
        break;
      }
    }
    for (int j = i; j < h; j++) {
      if (sequence[j] < root) {
        return false;
      }
    }
    return help(sequence, l, i - 1) && help(sequence, i, h - 1);
  }
};
