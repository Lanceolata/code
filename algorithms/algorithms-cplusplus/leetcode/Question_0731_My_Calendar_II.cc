#include <map>

using namespace std;

class MyCalendarTwo {
 public:
  MyCalendarTwo() {
  }
  
  bool book(int startTime, int endTime) {
    calendar[startTime] += 1;
    calendar[endTime] -= 1;
    int active = 0;
    for (map<int, int>::iterator it = calendar.begin(); it != calendar.end(); it++) {
      active += it->second;
      if (active >= 3) {
        calendar[startTime] -= 1;
        calendar[endTime] += 1;
        return false;
      }
    }
    return true;
  }

 private:
  map<int, int> calendar;
};
