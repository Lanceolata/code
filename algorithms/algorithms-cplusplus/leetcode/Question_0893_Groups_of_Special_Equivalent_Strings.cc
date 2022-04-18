#include <string>
#include <vector>
#include <unordered_set>

using namespace std;

class Solution {
 public:
  int numSpecialEquivGroups(vector<string>& words) {
    unordered_set<string> s;
    for (const auto& w : words) {
      pair<string,string> p;
      for (int i = 0; i < w.size(); ++i) {
        if (i % 2) {
          p.first += w[i];
        } else {
          p.second += w[i];
        }
      }
      sort(p.first.begin(), p.first.end());
      sort(p.second.begin(), p.second.end());
      s.insert(p.first + ":" + p.second);
    }
    return s.size();
  }
};
