#include <string>
#include <vector>
#include <sstream>
#include <iomanip>

using namespace std;

class Solution {
 public:
  string largestTimeFromDigits(vector<int>& arr) {
    int res = -1;
    for (int i1 = 0; i1 < arr.size(); ++i1) {
      for (int i2 = 0; i2 < arr.size(); ++i2) {
        for (int i3 = 0; i3 < arr.size(); ++i3) {
          if (i1 == i2 || i2 == i3 || i1 == i3) {
            continue;
          }
          int i4 = 6 - i1 - i2 - i3;
          vector<int> perm = {arr[i1], arr[i2], arr[i3], arr[i4]};
          res = max(res, validateTime(perm));
        }
      }
    }
    if (res == -1) {
      return "";
    }
    std::ostringstream strstream;
    strstream << std::setw(2) << std::setfill('0') << res / 60
        << ":" << std::setw(2) << std::setfill('0') << res % 60;
    return strstream.str();
  }

 private:
  int validateTime(vector<int>& perm) {
    int hour = perm[0] * 10 + perm[1];
    int minute = perm[2] * 10 + perm[3];
    return hour < 24 && minute < 60 ? hour * 60 + minute : -1;
  }
};
