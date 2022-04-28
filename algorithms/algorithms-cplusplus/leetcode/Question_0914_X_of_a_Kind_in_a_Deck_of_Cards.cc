#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
 public:
  bool hasGroupsSizeX(vector<int>& deck) {
    unordered_map<int, int> count;
    int res = 0;
    for (int i : deck) {
      count[i]++;
    }
    for (auto i : count) {
      res = gcd(i.second, res);
    }
    return res > 1;
  }

 private:
  int gcd(int a, int b) {
    return b > 0 ? gcd(b, a % b) : a;
  }
};
