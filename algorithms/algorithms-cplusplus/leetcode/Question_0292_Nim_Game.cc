
class Solution {
 public:
  bool canWinNim(int n) {
    return (n % 4 != 0);
  }
                
  bool canWinNim_fast(int n) {
    return (n&3);
  }
};
