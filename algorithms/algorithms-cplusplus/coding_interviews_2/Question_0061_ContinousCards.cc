#include <vector>
#include <algorithm>

using namespace std;

class Solution {
 public:
  bool IsContinuous(vector<int> numbers) {
    if (numbers.empty()) {
      return false;
    }
    sort(numbers.begin(), numbers.end());
    int zero = 0, gap = 0;
    for (int i = 0; i < numbers.size() - 1; i++) {
      if (numbers[i] == 0) {
        zero++;
      } else if (numbers[i] == numbers[i + 1]) {
        return false;
      } else {
        gap += numbers[i + 1] - numbers[i] - 1;
      }
    }
    return (gap > zero) ? false : true;
  }
};
