#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  vector<string> fizzBuzz(int n) {
    if (n <= 0) {
      return vector<string>();
    }
    vector<string> res;
    int three = 3, five = 5;
    for (int i = 1; i <= n; i++) {
      three--; five--;
      if (three == 0 && five == 0) {
        res.push_back("FizzBuzz");
        three = 3;
        five = 5;
      } else if (three == 0) {
        res.push_back("Fizz");
        three = 3;
      } else if (five == 0) {
        res.push_back("Buzz");
        five = 5;
      } else {
        res.push_back(to_string(i));
      }
    }
    return res;
  }
};
