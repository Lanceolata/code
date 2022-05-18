#include <string>
#include <map>
#include <unordered_map>

using namespace std;

class TimeMap {
 public:
  TimeMap() {
  }

  void set(string key, string value, int timestamp) {
    m[key].insert({timestamp, value});
  }

  string get(string key, int timestamp) {
    auto it = m[key].upper_bound(timestamp);
    return it == m[key].begin() ? "" : prev(it)->second;
  }

 private:
  unordered_map<string, map<int, string>> m;
};
