
class Solution {
 public:
  bool duplicate(int numbers[], int length, int* duplication) {
    if (length <= 1) {
      return false;
    }
    for (int i = 0; i < length; i++) {
        while (numbers[i] != i) {
            if (numbers[i] == numbers[numbers[i]]) {
                *duplication = numbers[i];
                return true;
            }
            int tmp = numbers[i];
            numbers[i] = numbers[tmp];
            numbers[tmp] = tmp;
        }
    }
    return false;
  }
};
