#include <string>

using namespace std;

class Solution {
public:
    string LeftRotateString(string str, int n) {
        if (str.empty()) {
            return str;
        }
        int len = str.size();
        int k = n % len;
        reverse(str, 0, k - 1);
        reverse(str, k, len - 1);
        reverse(str, 0, len - 1);
        return str;
    }
    
    void reverse(string& str, int l, int r) {
        while (l < r) {
            swap(str[l++], str[r--]);
        }
    }
};
