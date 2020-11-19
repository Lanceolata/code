#include <stdlib.h>
#include <vector>
#include <unordered_map>

using namespace std;

class RandomizedSet {
 public:
  /** Initialize your data structure here. */
  RandomizedSet() {
    
  }

  /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
  bool insert(int val) {
    if (m.find(val) != m.end()) {
      return false;
    }
    nums.emplace_back(val);
    // value -> index
    m[val] = nums.size() - 1;
    return true;
  }

  /** Removes a value from the set. Returns true if the set contained the specified element. */
  bool remove(int val) {
    if (m.find(val) == m.end()) {
      return false;
    }
    // 调整index
    // 最后一个元素
    int last = nums.back();
    // 设置last的索引等于val的索引
    m[last] = m[val];
    // 交换nums中 last和val
    nums[m[val]] = last;
    nums.pop_back();
    // 移除val
    m.erase(val);
    return true;
  }

  /** Get a random element from the set. */
  int getRandom() {
    return nums[rand() % nums.size()];
  }

 private:
  vector<int> nums;
  unordered_map<int, int> m;
};
