#include <vector>
#include <algorithm>
#include <unordered_set>

using namespace std;

class Solution {
 public:
  int distributeCandies(vector<int>& candyType) {
    unordered_set<int> s;
    for (int candy : candyType) {
      s.insert(candy);
    }
    return min(s.size(), candyType.size() / 2);
  }
};
