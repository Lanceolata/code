#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  int lengthLongestPath(string input) {
    vector<int> vec(1, 0);
    int res = 0, level = 0, cur = 0;
    bool isFile = false;
    for (int i = 0; i < input.size(); i++) {
      switch (input[i]) {
        case '\n':
          level = 0; cur = 0; isFile = false;
          break;
        case '\t':
          level++;
          break;
        case '.' :
          isFile = true;
        default:
          cur++;
          if (level + 1 >= vec.size()) {
            vec.push_back(0);
          }
          vec[level + 1] = vec[level] + cur + 1;
          if (isFile) {
            res = max(res, vec[level + 1] - 1);
          }
        }
    }
    return res;
  }
};
