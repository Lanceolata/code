#include <queue>

class MyStack {
 public:
  /** Initialize your data structure here. */
  MyStack() {}
                
  /** Push element x onto stack. */
  void push(int x) {
    q.push(x);
    t = x;
  }
                    
  /** Removes the element on top of the stack and returns that element. */
  int pop() {
    while (q.size() > 1) {
      t = q.front();
      q.pop();
      help.push(t);
    }
    int res = q.front();
    q.pop();
    std::queue<int> temp = std::move(q);
    q = std::move(help);
    help = std::move(temp);
    return res;
  }
                        
  /** Get the top element. */
  int top() {
    return t;
  }
                            
  /** Returns whether the stack is empty. */
  bool empty() {                                        
    return q.empty();
  }

 private:
  std::queue<int> q;
  std::queue<int> help;
  int t;
};
