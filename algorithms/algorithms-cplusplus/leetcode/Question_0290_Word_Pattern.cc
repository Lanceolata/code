#include <iostream>
#include <string>
#include <sstream>
#include <vector>

using namespace std;

class Solution {
 public:
  bool wordPattern(string pattern, string s) {
    istringstream strcin(s);
    string ss;
    vector<string> words;
    while(strcin >> ss) {
      words.push_back(ss);
    }
    vector<string> vec(26, "");
    if (words.size() != pattern.size()) {
      return false;
    }
    for (size_t i = 0; i < words.size(); ++i) {
      if (vec[pattern[i] - 'a'] == "") {
        for (int j = 0; j < 26; j++) {
          if (j != pattern[i] - 'a') {
            if (words[i] == vec[j]) {
              return false;
            }
          }
        }
        vec[pattern[i] - 'a'] = words[i];
      } else if (vec[pattern[i] - 'a'] != words[i]) {
        return false;
      }
    }
    return true;
  }
};
