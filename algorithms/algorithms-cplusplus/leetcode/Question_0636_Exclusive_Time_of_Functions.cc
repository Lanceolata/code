#include <vector>
#include <stack>
#include <sstream>

using namespace std;

struct Log {
  int id;
  bool isStart;
  int time;
  int subDuration;
};

class Solution {
 public:
  vector<int> exclusiveTime(int n, vector<string>& logs) {
    vector<int> res(n, 0);
    stack<Log> st;
    for(string log: logs) {
      stringstream ss(log);
      string temp, temp2, temp3;
      getline(ss, temp, ':');
      getline(ss, temp2, ':');
      getline(ss, temp3, ':');

      Log item = {stoi(temp), temp2 == "start", stoi(temp3), 0};
      if (item.isStart) {
        st.push(item);
      } else {
        int t = item.time - st.top().time + 1;
        res[st.top().id] += (t - st.top().subDuration);
        st.pop();
        if (!st.empty()) {
          st.top().subDuration += t;
        }
      }
    }
    return res;
  }
};
