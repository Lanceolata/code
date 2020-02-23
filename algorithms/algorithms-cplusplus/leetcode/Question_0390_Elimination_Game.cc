
class Solution {
 public:
  int lastRemaining(int n) {
    bool left = true;
    int head = 1, step = 1, remain = n;
    while (remain > 1) {
      if (left || remain % 2 != 0) {
        head = head + step;
      }
      remain = remain / 2;
      step *= 2;
      left = !left;
    }
    return head;
  }
};
