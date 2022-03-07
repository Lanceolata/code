#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  string shortestCompletingWord(string licensePlate, vector<string>& words) {
    vector<int> cnts(26, 0);
    for (char c : licensePlate) {
      if (isalpha(c)) {
        cnts[tolower(c) - 'a']++;
      }
    }
    string res;
    for (string& word : words) {
      vector<int> cnt(26, 0);
      for (char c : word) {
        cnt[c - 'a']++;
      }
      int i = 0;
      for (; i < 26; i++) {
        if (cnt[i] < cnts[i]) {
          break;
        }
      }
      if (i >= 26 && (res.empty() || word.size() < res.size())) {
        res = word;
      }
    }
    return res;
  }
};
 