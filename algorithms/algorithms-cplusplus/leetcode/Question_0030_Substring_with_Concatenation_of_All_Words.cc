#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
 public:
  vector<int> findSubstring(string s, vector<string>& words) {
    vector<int> res;
    if (s.empty() || words.empty()) {
      return res;
    }
    unordered_map<string, int> m1;
    for (string& word : words) {
      m1[word]++;
    }
    int n = s.size(), cnt = words.size(), len = words[0].size();
    for (int i = 0; i < len; i++) {
      int left = i, count = 0;
      unordered_map<string, int> m2;
      for (int j = i; j <= n - len; j += len) {
        string t = s.substr(j, len);
        if (m1.find(t) != m1.end()) {
          ++m2[t]; ++count;
          while (m2[t] > m1[t]) {
            string t1 = s.substr(left, len);
            --m2[t1];
            --count;
            left += len;
          }
          if (count == cnt) {
            res.push_back(left);
            --m2[s.substr(left, len)];
            --count;
            left += len;
          }
        } else {
          m2.clear();
          count = 0;
          left = j + len;
        }
      }
    }
    return res;
  }

  vector<int> findSubstring_sample(string s, vector<string>& words) {
    vector<int> res;
    if (s.empty() || words.empty()) {
      return res;
    }
    unordered_map<string, int> m1;
    for (string& word : words) {
      m1[word]++;
    }
    int m = words.size(), n = words[0].size();
    for (int i = 0; i < (int)s.size() - m * n; i++) {
      unordered_map<string, int> m2;
      int j = 0;
      for (; j < m; j++) {
        string t = s.substr(i + j * n, n);
        if (m1.find(t) == m1.end()) {
          break;
        }
        ++m2[t];
        if (m2[t] > m1[t]) {
          break;
        }
      }
      if (j == m) {
        res.push_back(i);
      }
    }
    return res;
  }
};
