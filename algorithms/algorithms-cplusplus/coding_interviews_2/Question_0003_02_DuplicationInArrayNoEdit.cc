
class Solution {
 public:
  bool duplicate(int numbers[], int length, int* duplication) {
    if (length <= 0) {
      return false;
    }
    int l = 1, r = length - 1, m;
    while (l < r) {
      // 对1 ~ length - 1 的数字进行二分
      m = l + (r - l) / 2;
      // 统计 l ~ m 数字的个数
      int count = countRange(numbers, length, l, m);
      if (count > m - l + 1) {
        // 个数 大于 l ~ m的长度  则重复数字在 l ~ m中
        r = m;
      } else {
        l = m + 1;
      }
    }
    if (countRange(numbers, length, l, l) > 1) {
      *duplication = l;
      return true;
    }
    return false;
  }

  int countRange(int numbers[], int length, int l, int r) {
    int count = 0;
    for (int i = 0; i < length; i++) {
      if (numbers[i] >= l && numbers[i] <= r) {
        count++;
      }
    }
    return count;
  }
};
