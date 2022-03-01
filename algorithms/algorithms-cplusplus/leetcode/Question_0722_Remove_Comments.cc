#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  vector<string> removeComments(vector<string>& source) {
    vector<string> res;
    string s;
    bool comment = false;
    for (string& l : source) {
      for (int i = 0; i < l.size(); i++) {
        if(!comment && i + 1 < l.size() && l[i] == '/' && l[i + 1] == '/') {
          break;
        }
        if (!comment && i + 1 < l.size() && l[i] == '/' && l[i + 1] == '*') {
          comment = true;
          i++;
        } else if (comment && i + 1 < l.size() && l[i] == '*' && l[i + 1] == '/') {
          comment = false;
          i++;
        } else if (!comment) {
          s.push_back(l[i]);
        }
      }
      if(!comment && s.size()) {
        res.push_back(s);
        s.clear();
      }
    }
    return res;
  }
};
