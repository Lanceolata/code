#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

class MagicDictionary {
 public:
  MagicDictionary() {
  }
    
  void buildDict(vector<string> dictionary) {
    for (string s : dictionary) {
      for (int i = 0; i < s.size(); i++) {
        string key = s.substr(0, i) + s.substr(i + 1);
        m[key].push_back({i, s[i]});
      }
    }
  }
    
  bool search(string searchWord) {
    for (int i = 0; i < searchWord.size(); i++) {
      string key = searchWord.substr(0, i) + searchWord.substr(i + 1);
      if (m.find(key) != m.end()) {
        for (pair<int, int> p : m[key]) {
          if (p.first == i && p.second != searchWord[i]) {
            return true;
          }
        }
      }
    }
    return false;
  }
 private:
  unordered_map<string, vector<pair<int, int>>> m;
};
