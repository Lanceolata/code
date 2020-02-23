
class Solution {
 public:
  void replaceSpace(char *str,int length) {
    if (!str || length <= 0) {
      return;
    }
    // len是长度，不是索引，当做为索引使用时，已经包含了最后的\0
    int len = 0, i = 0;
    while (str[i] != '\0') {
      if (str[i] == ' ') {
        len += 3;
      } else {
        len++;
      }
      i++;
    }
    if (len > length) {
      return;
    }
    while (i >= 0 && i < len) {
      if (str[i] == ' ') {
        str[len--] = '0';
        str[len--] = '2';
        str[len--] = '%';
      } else {
        str[len--] = str[i];
      }
      i--;
    }
  }
};
