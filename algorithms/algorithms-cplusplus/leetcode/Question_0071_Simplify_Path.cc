#include <string>
#include <vector>
#include <sstream>

using namespace std;

class Solution {
 public:
  string simplifyPath(string path) {
    string s, res;
    istringstream istr(path);
    vector<string> vec;
    while (getline(istr, s, '/')) {
      if (s == "" || s == ".") {
        continue;
      }
      if (s == "..") {
        if (!vec.empty()) vec.pop_back();
        continue;
      }
      vec.push_back(s);
    }
    for (string& s : vec) {
      res += "/" + s;
    }
    return res.empty() ? "/" : res;
  }
};
