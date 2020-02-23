
bool isBadVersion(int version);

class Solution {
 public:
  int firstBadVersion(int n) {
    int l = 0, r = n, m;
    while (l <= r) {
      m = l + (r - l) / 2;
      if (isBadVersion(m)) {
        r = m - 1;
      } else {
        l = m + 1;
      }
    }
    return l;
  }
};
