#include <string>
#include <vector>
#include <unordered_map>
#include <unordered_set>

using namespace std;

class Solution {
 public:
  bool pyramidTransition(string bottom, vector<string>& allowed) {
    unordered_map<string, vector<char>> m;
    unordered_set<string> invalid;
    for(string& s : allowed) {
      m[s.substr(0, 2)].push_back(s.back());
    }
    return help(bottom, m, invalid);
  }

 private:
  bool help(string& bottom, unordered_map<string, vector<char>>& m, unordered_set<string>& invalid){
    if(bottom.size() == 1) {
      return true;
    }
    if (invalid.find(bottom) != invalid.end()) {
      return false;
    }
    for (int i = 0; i < bottom.size() - 1; i++) {
      if (m.find(bottom.substr(i, 2)) == m.end()) {
        return false;
      }
    }
    vector<string> nexts;
    string s;
    getNexts(bottom, m, 0, s, nexts);
    for (string& n : nexts) {
      if (help(n, m, invalid)) {
        return true;
      }
      invalid.insert(n);
    }
    return false;
  }

  void getNexts(string& bottom, unordered_map<string, vector<char>>& m, int idx, string& s, vector<string>& nexts) {
    if (idx >= bottom.size() - 1) {
      nexts.push_back(s);
      return;
    }
    for (char c : m[bottom.substr(idx, 2)]) {
      s.push_back(c);
      getNexts(bottom, m , idx + 1, s, nexts);
      s.erase(s.end() - 1);
    }
  }
};
