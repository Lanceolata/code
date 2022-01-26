#include <string>
#include <sstream>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
 public:
  vector<vector<string>> findDuplicate(vector<string>& paths) {
    vector<vector<string>> res;
    if (paths.empty()) {
      return res;
    }
    unordered_map<string, vector<string>> files;
    for (auto path : paths) {
	  stringstream ss(path);
	  string root;
	  string s;
	  getline(ss, root, ' ');
	  while (getline(ss, s, ' ')) {
		string fileName = root + '/' + s.substr(0, s.find('('));
		string fileContent = s.substr(s.find('(') + 1, s.find(')') - s.find('(') - 1);
		files[fileContent].push_back(fileName);
	  }
    }
    for (auto file : files) {
	  if (file.second.size() > 1) {
        res.push_back(file.second);
      }	    
    }
    return res;
  }
};
