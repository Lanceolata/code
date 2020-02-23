#include <list>

using namespace std;

class Solution {
 public:
  int LastRemaining1(int n, int m) {
    if (m < 1 || n < 1) {
      return -1;
    }
    list<int> numbers;
    for (int i = 0; i < n; i++) {
      numbers.push_back(i);
    }

    list<int>::iterator current = numbers.begin();
    while(numbers.size() > 1) {
      for(int i = 1; i < m; ++ i) {
        current++;
        if(current == numbers.end()) {
          current = numbers.begin();
        }
      }

      list<int>::iterator next = ++ current;
    }
  }

  int LastRemaining2(int n, int m) {
    if (m < 1 || n < 1) {
      return -1;
    }
    int last = 0;
    for (int i = 2; i <= n; i++) {
      last = (last + m) % i;
    }
    return last;
  }
};
