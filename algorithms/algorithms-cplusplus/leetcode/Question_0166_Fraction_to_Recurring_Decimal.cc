#include <string>
#include <algorithm>
#include <unordered_map>

using namespace std;

class Solution {
 public:
  string fractionToDecimal(int numerator, int denominator) {
    if (denominator == 0) {
      return "";
    }
    string res;
    if(numerator < 0 ^ denominator < 0) {
      res += '-';
    }
    long long n = abs((long long)numerator), d = abs((long long)denominator);
    res += to_string(n / d);
    long long r = n % d;
    if(r == 0) {
      return res;
    } else {
      res += '.';
    }
    unordered_map<int,int> map;
    while (r) {
      if(map.find(r) != map.end()) {
        res.insert(map[r], 1, '(');
        res += ')';
        break;
      }
      map[r] = res.size();
      r *= 10;
      res += to_string(r / d);
      r = r % d;
    }
    return res;
  }
};
