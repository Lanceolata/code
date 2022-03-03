#include <map>

using namespace std;

class MyCalendar {
 public:
  MyCalendar() {
  }

  bool book(int start, int end) {
    map<int,int>::iterator next = calendar.lower_bound(start);
    if (next != calendar.end() && next->first < end) {
      return false;
    }
    if (next != calendar.begin() && start < (--next)->second) {
      return false;
    }
    calendar[start] = end;
    return true;
  }

 private:
  map<int,int> calendar;
};
