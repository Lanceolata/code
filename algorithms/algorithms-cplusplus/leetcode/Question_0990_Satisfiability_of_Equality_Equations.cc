#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  bool equationsPossible(vector<string>& equations) {
    vector<int> uf(26, 0);
    for (int i = 0; i < 26; ++i) {
      uf[i] = i;
    }
    for (string& e : equations) {
      if (e[1] == '=') {
        uf[find(e[0] - 'a', uf)] = find(e[3] - 'a', uf);
      }
    }
    for (string e : equations) {
      if (e[1] == '!' && find(e[0] - 'a', uf) == find(e[3] - 'a', uf)) {
        return false;
      }
    }
    return true;
  }

 private:
  int find(int x, vector<int>& uf) {
    if (x != uf[x]) {
      uf[x] = find(uf[x], uf);
    }
    return uf[x];
  }
};
