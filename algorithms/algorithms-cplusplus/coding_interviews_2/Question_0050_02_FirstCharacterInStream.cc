#include <limits.h>
#include <vector>

using namespace std;

class Solution {
 public:
  Solution(): index(0), vec(256, -1) {}

  //Insert one char from stringstream
  void Insert(char ch) {
    if (vec[ch] == -1) {
      vec[ch] = index;
    } else if (vec[ch] >= 0) {
      vec[ch] = -2;
    }
    index++;
  }
  //return the first appearence once char in current stringstream
  char FirstAppearingOnce() {
    int res = -1, index = INT_MAX;
    for (int i = 0; i < vec.size(); i++) {
      if (vec[i] >= 0 && vec[i] < index) {
        res = i;
        index = vec[i];
      }
    }
    if (res == -1) {
      return '#';
    }
    return (char)res;
  }

 private:
  int index = 0;
  vector<int> vec;
};
