#include <vector>
#include <map>

using namespace std;

class Solution {
 public:
  int largestValsFromLabels(vector<int>& values, vector<int>& labels, int numWanted, int useLimit) {
    vector<pair<int, int>> valLab;
    for (int i = 0; i < values.size(); i++) {
      valLab.push_back({values[i], labels[i]});
    }
    sort(valLab.begin(), valLab.end(), myComp);

    map<int, int> hashLabel;
    
    int sum = 0;
    for (int i = 0; i < values.size(); i++) {
      int val = valLab[i].first;
      int lab = valLab[i].second;

      if (numWanted > 0 && hashLabel[lab] < useLimit) {
        sum += val;
        hashLabel[lab] += 1;
        numWanted--;
      }
    }

    return sum;
  }

  static bool myComp(pair<int, int> a, pair<int, int> b) {
    return a.first > b.first;
  }
};
