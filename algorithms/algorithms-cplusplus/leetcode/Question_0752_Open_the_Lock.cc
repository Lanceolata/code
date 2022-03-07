#include <string>
#include <vector>
#include <unordered_set>
#include <queue>

using namespace std;

class Solution {
 public:
  int openLock(vector<string>& deadends, string target) {
    if (target == "0000") {
      return 0;
    }
    unordered_set<string> deadlock(deadends.begin(), deadends.end());
    if (deadlock.count("0000")) {
      return -1;
    }
    int res = 0;
    unordered_set<string> visited{{"0000"}};
    queue<string> q{{"0000"}};
    while (!q.empty()) {
      res++;
      for (int k = q.size(); k > 0; k--) {
        string s = q.front();
        q.pop();
        for (int i = 0; i < s.size(); i++) {
          char c = s[i];
          s[i] = c == '9' ? '0' : c + 1;
          if (help(target, s, deadlock, visited, q)) {
            return res;
          }
          s[i] = c == '0' ? '9' : c - 1;
          if (help(target, s, deadlock, visited, q)) {
            return res;
          }
          s[i] = c;
        }
      }
    }
    return -1;
  }

 private:
  bool help(string& target, string& s, unordered_set<string>& deadlock, unordered_set<string>& visited, queue<string>& q) {
    if (s == target) {
      return true;
    }
    if (!visited.count(s) && !deadlock.count(s)){
      visited.insert(s);
      q.push(s);
    }
    return false;
  }
};
