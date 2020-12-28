#include <vector>
#include <string>
#include <unordered_set>

using namespace std;

class Solution {
 public:
  int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
    unordered_set<string> begin({beginWord}), end({endWord}),
        bank(wordList.begin(), wordList.end());
    if (bank.find(endWord) == bank.end()) {
      return 0;
    }
    return help(begin, end, bank, 1);
  }

  int help(unordered_set<string>& begin, unordered_set<string>& end,
      unordered_set<string>& bank, int level) {
    if (begin.empty()) {
      return 0;
    }
    level += 1;
    unordered_set<string> newBegin;
    for (string s : begin) {
      for (size_t i = 0; i < s.size(); i++) {
        char tem = s[i];
        for (char ch = 'a'; ch <= 'z'; ch++) {
          if (ch != tem) {
            s[i] = ch;
            if (end.find(s) != end.end()) {
              return level;
            }
            if (bank.find(s) != bank.end()) {
              newBegin.insert(s);
              bank.erase(s);
            }
          }
        }
        s[i] = tem;
      }
    }

    if (newBegin.size() > end.size()) {
      return help(end, newBegin, bank, level);
    } else {
      return help(newBegin, end, bank, level);
    }
  }
};
