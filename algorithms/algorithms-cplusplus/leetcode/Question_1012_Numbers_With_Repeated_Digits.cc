#include <vector>
#include <unordered_set>

using namespace std;

class Solution {
 public:
  int numDupDigitsAtMostN(int n) {
    // Transform n + 1 to arrayList
    vector<int> vec;
    for (int x = n + 1; x > 0; x /= 10) {
      vec.insert(vec.begin(), x % 10);
    }
    
    // Count the number with digits < n
    int res = 0, size = vec.size();
    for (int i = 1; i < size; i++) {
      res += 9 * count(9, i - 1);
    }
    
    // Count the number with same prefix
    unordered_set<int> seen;
    for (int i = 0; i < size; i++) {
      for (int j = i > 0 ? 0 : 1; j < vec[i]; j++) {
        if (seen.count(j) == 0) {
          res += count(9 - i, size - i - 1);
        }
      }
      if (seen.count(vec[i]) > 0) {
        break;
      }
      seen.insert(vec[i]);
    }
    return n - res;
  }

  int count(int m, int n) {
    return n == 0 ? 1 : count(m, n - 1) * (m - n + 1);
  }
};
