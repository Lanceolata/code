#include <vector>

using namespace std;

class MyCircularQueue {
 public:
  MyCircularQueue(int k) {
    data.resize(k);
    head = 0;
    tail = 0;
    reset = true;
  }
    
  bool enQueue(int value) {
    if (isFull()) {
      return false;
    }
    if (isEmpty()) {
      reset = false;
    }
    data[tail] = value;
    tail = (tail + 1) % data.size();
    return true;
  }
    
  bool deQueue() {
    if (isEmpty()) {
      return false;
    }
    head = (head + 1) % data.size();
    if (isFull()) {
      reset = true; 
    }
    return true;
  }
    
  int Front() {
    if (isEmpty()) {
      return -1;
    }
    return data[head];
  }
    
  int Rear() {
    if (isEmpty()) {
      return -1;
    }
    return data[(tail + data.size() - 1) % data.size()];
  }
    
  bool isEmpty() {
    return tail == head && reset;
  }
    
  bool isFull() {
    return tail == head && !reset;
  }

 private:
  vector<int> data;
  int head;
  int tail;
  // reset is the mark when the queue is empty
  // to differentiate from queue is full
  // because in both conditions (tail == head) stands
  bool reset;
};
