#include <stdlib.h>
#include <vector>

using namespace std;

class Solution {
 public:
  Solution(vector<int>& nums) {
    vec = nums;
  }

  /** Resets the array to its original configuration and return it. */
  vector<int> reset() {
    return vec;
  }

  /** Returns a random shuffling of the array. */
  vector<int> shuffle() {
    vector<int> res(vec);
    for (int i = 0; i < res.size(); i++) {
      swap(res[i], res[randRange(i, res.size())]);
    }
    return res;
  }

 private:
  vector<int> vec;

  int randRange(int start, int end) {
    return (rand() % (end - start)) + start;
  }
};
