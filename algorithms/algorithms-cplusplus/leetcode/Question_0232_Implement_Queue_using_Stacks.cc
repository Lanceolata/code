#include <stack>

class MyQueue {
 public:
  /** Initialize your data structure here. */
  MyQueue() {}
                
  /** Push element x to the back of queue. */
  void push(int x) {
    values.push(x);
  }
                    
  /** Removes the element from in front of queue and returns that element. */
  int pop() {
    int res = peek();
    help.pop();
    return res;
  }
                        
  /** Get the front element. */
  int peek() {
    if (help.empty()) {
      while (!values.empty()) {
        help.push(values.top());
        values.pop();
      }
    }
    return help.top();
  }
                            
  /** Returns whether the queue is empty. */
  bool empty() {
    return values.empty() && help.empty();
  }

 private:
  std::stack<int> values;
  std::stack<int> help;
};
