#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  bool canConstruct(string ransomNote, string magazine) {
    if (ransomNote.size() > magazine.size()) {
      return false;
    }
    vector<int> index(256, 0);
    for (char c : magazine) {
      index[c]++;
    }
    for (char c : ransomNote) {
      index[c]--;
    }
    for (int i : index) {
      if (i < 0) {
        return false;
      }
    }
    return true;
  }
};
