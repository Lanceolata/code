#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  int numMatchingSubseq(string s, vector<string>& words) {
    vector<vector<pair<int, int>>> waiting(128);
    for (int i = 0; i < words.size(); i++) {
      waiting[words[i][0]].emplace_back(i, 0);
    }
    int res = 0;
    for (char c : s) {
      vector<pair<int, int>> vec = waiting[c];
      waiting[c].clear();
      for (pair<int, int>& it : vec) {
        string& w = words[it.first];
        if (it.second + 1 >= w.size()) {
          res++;
        } else {
          waiting[w[it.second + 1]].push_back({it.first, it.second + 1});
        }
      }
    }
    return res;
  }
};
