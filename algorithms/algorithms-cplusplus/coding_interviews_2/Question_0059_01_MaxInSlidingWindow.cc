#include <vector>
#include <deque>

using namespace std;

class Solution {
 public:
  vector<int> maxInWindows(const vector<int>& num, unsigned int size) {
    vector<int> res;
    if (num.empty() || num.size() < size || size <= 0) {
      return res;
    }
    deque<int> que;
    for (int i = 0; i < num.size(); i++) {
      if (i >= size && num[i - size] == que.front()) {
        que.pop_front();
      }
      while(!que.empty() && que.back() < num[i]) {
        que.pop_back();
      }
      que.push_back(num[i]);
      if (i >= size - 1) {
        res.push_back(que.front());
      }
    }
    return res;
  }  

  vector<int> maxInWindowsIndex(const vector<int>& num, unsigned int size) {
    vector<int> res;
    if (num.empty() || num.size() < size) {
      return res;
    }
    deque<int> que;
    for (int i = 0; i < num.size(); i++) {
      // que.front() + size <= i 防止unsigned溢出
      if (!que.empty() && que.front() + size <= i) {
        que.pop_front();
      }
      while(!que.empty() && num[i] >= num[que.back()]) {
        que.pop_back();
      }
      que.push_back(i);
      if (i >= size - 1) {
        res.push_back(num[que.front()]);
      }
    }
    return res;
  }
};
