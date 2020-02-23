
class Solution {
 public:
  bool isPalindrome(int x) {
    if (x < 0) {
      return false;
    }
    int help = 1;
    while (x / help >= 10) {
      help *= 10;
    }
    while (x != 0) {
      if (x / help != x % 10) {
        return false;
      }
      x = (x % help) / 10;
      help /= 100;
    }
    return true;
  }
};
