#include <stdio.h>
#include <algorithm>
#include <vector>
#include <map>

using namespace std;

class SummaryRanges {
 public:
  /** Initialize your data structure here. */
  SummaryRanges() {
        
  }
    
  void addNum(int val) {
    if (m.find(val) != m.end()){
      return;
    }
    int l = lowerKey(val);
    int r = higherKey(val);
    if (l != -1 && r != -1 && m[l][1] + 1 == val && r == val + 1){
      m[l][1] = m[r][1];
      m.erase(r);
    } else if (l != -1 && m[l][1] + 1 >= val){
      m[l][1] = max(m[l][1], val);
    } else if (r != -1 && r == val + 1) {
      m[val] = {val, m[r][1]};
      m.erase(r);
    } else {
      m[val] = {val, val};
    }
  }
    
  vector<vector<int>> getIntervals() {
    vector<vector<int> > res;
    for (auto &i : m){
      res.push_back(i.second);
    }
    return res;
  }

 private:
  map<int, vector<int> > m;

  int lowerKey(int key) {
    auto pos = m.lower_bound(key);
    if(pos == m.begin()) {
      return -1;
    } 
    return (--pos)->first;
  }

  int higherKey(int key) {
    auto pos = m.upper_bound(key);
    if(pos == m.end()){
      return -1;
    } 
    return pos->first;
  }
};
