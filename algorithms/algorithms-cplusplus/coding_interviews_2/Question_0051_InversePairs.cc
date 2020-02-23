#include <vector>

using namespace std;

class Solution {
 public:
  int InversePairs(vector<int> data) {
    if (data.empty()) {
      return 0;
    }
    long long count = 0;
    vector<int> copy(data);
    count = InversePairs(data, copy, 0, data.size() - 1);
    return count % 1000000007;
  }

  long long InversePairs(vector<int>& data, vector<int>& copy, int l, int r) {
    if (l >= r) {
      copy[l] = data[l];
      return 0;
    }
    int m = l + (r - l) / 2;
    long long left = InversePairs(copy, data, l, m);
    long long right = InversePairs(copy, data, m + 1, r);
    int i = m, j = r, index = r;
    long long count = 0;
    while (i >= l && j > m) {
      if (data[i] > data[j]) {
        count += j - m;
        copy[index--] = data[i--];
      } else {
        copy[index--] = data[j--];
      }
    }
    while (i >= l) {
      copy[index--] = data[i--];
    }
    while (j > m) {
      copy[index--] = data[j--];
    }
    return left + right + count;
  }
};
