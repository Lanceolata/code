#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  vector<string> wordSubsets(vector<string>& words1, vector<string>& words2) {
    vector<int> targets(26, 0);
    for (string& w : words2) {
      vector<int> tmp = counts(w);
      for (int i = 0; i < 26; i++) {
        targets[i] = max(targets[i], tmp[i]);
      }
    }
    vector<string> res;
    for (string& w : words1) {
      vector<int> tmp = counts(w);
      int i = 0;
      for (; i < 26; i++) {
        if (tmp[i] < targets[i]) {
          break;
        }
      }
      if (i >= 26) {
        res.push_back(w);
      }
    }
    return res;
  }

 private:
  vector<int> counts(string& w) {
    vector<int> res(26, 0);
    for (char c : w) {
      res[c - 'a']++;
    }
    return res;
  }
};
