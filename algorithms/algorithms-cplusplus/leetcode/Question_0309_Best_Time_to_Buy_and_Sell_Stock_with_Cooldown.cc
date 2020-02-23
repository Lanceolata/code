#include <limits.h>
#include <vector>

using namespace std;

class Solution {
 public:
  int maxProfit(vector<int>& prices) {
    int buy = INT_MIN, sell = 0, pre_sell = 0, pre_buy = 0;
    for (int p : prices) {
      pre_buy = buy;
      buy = max(pre_sell - p, buy);
      pre_sell = sell;
      sell = max(pre_buy + p, sell);
    }
    return sell;
  }
};
