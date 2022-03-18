#include <string>
#include <vector>
#include <unordered_set>

using namespace std;

class Solution {
 public:
  int uniqueMorseRepresentations(vector<string>& words) {
    vector<string> morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    unordered_set<string> data;
    for (string& w : words) {
      string s = "";
      for (char c : w) {
        s += morse[c - 'a'];
      }
      data.emplace(s);
    }
    return data.size();
  }
};
