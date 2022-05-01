#include <string>

using namespace std;

class Solution {
 public:
  bool isLongPressedName(string name, string typed) {
    if (typed.size() < name.size()) {
      return false;
    }
    int i = 0, j = 0;
    while (i < name.size() && j < typed.size()) {
      if (name[i] == typed[j]) {
        i++;
        j++;
      } else if (j > 0 && typed[j] == typed[j - 1]) {
        j++;
      } else {
        return false;
      }
    }
    while (j < typed.size() && j > 0 && typed[j] == typed[j - 1]) {
      j++;
    }
    return i == name.size() && j == typed.size();
  }
};
