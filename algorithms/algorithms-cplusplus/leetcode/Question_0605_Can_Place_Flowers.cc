#include <vector>

using namespace std;

class Solution {
 public:
  bool canPlaceFlowers(vector<int>& flowerbed, int n) {
    if (n <= 0) {
      return true;
    }
    int size = flowerbed.size();
    for (int i = 0; i < size; i++) {
      if (flowerbed[i] == 1) {
        continue;
      }
      if ((i == 0 || flowerbed[i - 1] == 0) && (i == size - 1 || flowerbed[i + 1] == 0)) {
        n--;
        flowerbed[i] = 1;
      }
      if (n == 0) {
        return true;
      }
    }
    return false;
  }
};
