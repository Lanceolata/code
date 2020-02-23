#include <algorithm>
#include <vector>

using namespace std;

class Solution {
 public:
  int hIndex(vector<int>& citations) {
    sort(citations.begin(), citations.end());
    for (int i = citations.size() - 1; i >= 0; i--) {
      if (citations.size() - 1 - i >= citations[i]) {
        return citations.size() - 1 - i;
      }
    }
    return citations.size();
  }
};
