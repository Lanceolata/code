#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  string findReplaceString(string s, vector<int>& indices, vector<string>& sources, vector<string>& targets) {
    vector<pair<int, int>> sorted;
    for (int i = 0 ; i < indices.size(); i++) {
      sorted.push_back({indices[i], i});
    }
    sort(sorted.rbegin(), sorted.rend());
    for (auto ind : sorted) {
      int i = ind.first;
      string str = sources[ind.second], t = targets[ind.second];
      if (s.substr(i, str.size()) == str) {
        s = s.substr(0, i) + t + s.substr(i + str.length());
      }
    }
    return s;
  }
};
