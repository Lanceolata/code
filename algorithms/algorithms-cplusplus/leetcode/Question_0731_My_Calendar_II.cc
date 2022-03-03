#include <map>

using namespace std;

class MyCalendarTwo {
 public:
  MyCalendarTwo() {
  }
  
  bool book(int start, int end) {
    calendar[start] += 1;
    calendar[end] -= 1;
    int active = 0;
    for (map<int, int>::iterator it = calendar.begin(); it != calendar.end(); it++) {
      active += it->second;
      if (active >= 3) {
        calendar[start] -= 1;
        calendar[end] += 1;
        return false;
      }
    }
    return true;
  }

 private:
  map<int, int> calendar;
};
