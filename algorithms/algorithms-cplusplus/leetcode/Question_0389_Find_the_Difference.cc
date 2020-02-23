#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  char findTheDifference(string s, string t) {
    int count = t[t.size() - 1];
    for (int i = 0; i < s.size(); i++) {
      count -= s[i];
      count += t[i];
    }
    return (char)count;
  }
};
