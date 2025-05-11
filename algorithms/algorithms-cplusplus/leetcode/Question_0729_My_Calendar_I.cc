#include <map>

using namespace std;

class MyCalendar {
 public:
  MyCalendar() {
  }

  bool book(int startTime, int endTime) {
    map<int,int>::iterator next = calendar.lower_bound(startTime);
    if (next != calendar.end() && next->first < endTime) {
      return false;
    }
    if (next != calendar.begin() && startTime < (--next)->second) {
      return false;
    }
    calendar[startTime] = endTime;
    return true;
  }

 private:
  map<int,int> calendar;
};
