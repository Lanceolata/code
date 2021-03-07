#include <vector>

using namespace std;

class NumArray {
 public:
  NumArray(vector<int>& nums) {
    if (!nums.empty()) {
      n = nums.size();
      tree.resize(2 * n);
      build(nums);
    }
  }

  void update(int index, int val) {
    index += n;
    tree[index] = val;
    while (index > 0) {
      int left = index;
      int right = index;
      if (index % 2 == 0) {
        right = index + 1;
      } else {
        left = index - 1;
      }
      // parent is updated after child is updated
      tree[index / 2] = tree[left] + tree[right];
      index /= 2;
    }
  }

  int sumRange(int left, int right) {
    // get leaf with value 'i'
    left += n;
    // get leaf with value 'j'
    right += n;
    int sum = 0;
    while (left <= right) {
      if ((left % 2) == 1) {
        sum += tree[left];
        left++;
      }
      if ((right % 2) == 0) {
        sum += tree[right];
        right--;
      }
      left /= 2;
      right /= 2;
    }
    return sum;
  }

 private:
  int n = 0;
  vector<int> tree;

  void build(vector<int>& nums) {
    for (int i = n, j = 0; i < 2 * n; i++, j++) {
      tree[i] = nums[j];
    }
    for (int i = n - 1; i > 0; i--) {
      tree[i] = tree[i * 2] + tree[i * 2 + 1];
    }
  }
};
