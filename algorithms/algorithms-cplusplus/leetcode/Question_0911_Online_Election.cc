#include <vector>
#include <unordered_map>

using namespace std;

class TopVotedCandidate {
 public:
  TopVotedCandidate(vector<int>& persons, vector<int>& times) {
    int n = persons.size(), lead = -1;
    this->times = times;
    unordered_map<int, int> count;
    for (int i = 0; i < n; ++i) {
      lead = ++count[persons[i]] >= count[lead] ? persons[i] : lead;
      m[times[i]] = lead;
    }
  }
  
  int q(int t) {
    return m[*--upper_bound(times.begin(), times.end(), t)];
  }

 private:
  unordered_map<int, int> m;
  vector<int> times;
};
