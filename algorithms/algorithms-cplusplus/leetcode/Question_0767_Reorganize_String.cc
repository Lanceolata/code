#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  string reorganizeString(string s) {
    vector<int> cnts(26);
	int mostFreq = 0, i = 0;
	for (char c : s) {
      if (++cnts[c - 'a'] > cnts[mostFreq]) {
        mostFreq = (c - 'a');
      }
    }
	if (2 * cnts[mostFreq] - 1 > s.size()) {
      return "";
    }
	while (cnts[mostFreq]) {
		s[i] = ('a' + mostFreq);
		i += 2;
		cnts[mostFreq]--;
	}
	for (int j = 0; j < 26; j++) {
	  while (cnts[j]) {
		if(i >= s.size()) {
          i = 1;
        }
		s[i] = ('a' + j);
		cnts[j]--;
		i += 2;
	  }
	}
	return s;
  }
};
