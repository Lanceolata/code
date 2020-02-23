#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  string getHint(string secret, string guess) {
    if (secret.empty() || guess.empty()) {
      return "";
    }
    vector<int> m(256, 0);
    int a = 0, b = 0;
    for (int i = 0; i < secret.size(); i++) {
      char s = secret[i], g = guess[i];
      if (s == g) {
        a++;
      }
      if (m[s]++ < 0) {
         b++;
      }
      if (m[g]-- > 0) {
        b++;
      }
    }
    return to_string(a) + "A" + to_string(b - a) + "B";
  }
};
