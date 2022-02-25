#include <vector>
#include <queue>

using namespace std;

class KthLargest {
 public:
  KthLargest(int k, vector<int>& nums): k(k) {
    for (int n : nums) {
      q.push(n);
    }
    while (q.size() > k) {
      q.pop();
    }
  }
    
  int add(int val) {
    q.push(val);
    if (q.size() > k) {
      q.pop();
    }
    return q.top();
  }

 private:
  int k;
  priority_queue<int, vector<int>, greater<int>> q;
};
