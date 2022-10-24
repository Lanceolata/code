#include <queue>

using namespace std;

class MedianFinder {
 public:
  MedianFinder() {
  }
    
  void addNum(int num) {
    if (even) {
      large.push(num);
      small.push(large.top());
      large.pop();
    } else {
      small.push(num);
      large.push(small.top());
      small.pop();
    }
    even = !even;
  }
    
  double findMedian() {
    if (even) {
      return (small.top() + large.top()) / 2.0;
    } else {
      return small.top();
    }
  }

 private:
  priority_queue<int, vector<int>, greater<int>> small;
  priority_queue<int> large;
  bool even = true;
};