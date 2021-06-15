#include <limits.h>
#include <stack>

class MinStack {
 public:
  /** initialize your data structure here. */
  MinStack() {
  }
  
  void push(int val) {
    if (values.empty()) {
      values.push(0L);
      min = val;
    } else {
      values.push(val - min);
      if (val < min) {
        min = val;
      }
    }
  }
                    
  void pop() {
    if (values.empty()) {
      return;
    }
    long pop = values.top();
    values.pop();
    if (pop < 0) {
      min = min - pop;
    }
  }
                        
  int top() {
    long top = values.top();
    if (top > 0) {
      return (int)(top + min);
    } else {
      return (int)(min);
    }
  }
                            
  int getMin() {
    return (int)min;
  }

 private:
  std::stack<long> values;
  long min;
};
