#include <vector>
#include <set>
#include <unordered_map>

using namespace std;

class Solution {
 public:
  vector<int> rearrangeBarcodes(vector<int>& barcodes) {
    unordered_map<int, int> m;
    set<pair<int, int>> s;
    for (auto n : barcodes) {
      ++m[n];
    }
    for (auto it = begin(m); it != end(m); ++it) {
      s.insert({ it->second, it->first });
    }
    int pos = 0;
    for (auto it = s.rbegin(); it != s.rend(); ++it) {
      for (auto cnt = 0; cnt < it->first; ++cnt, pos += 2) {
        if (pos >= barcodes.size()) {
          pos = 1;
        }
        barcodes[pos] = it->second;
      }
    }
    return barcodes;
  }
};
