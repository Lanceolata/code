#include <vector>
#include <unordered_map>

using namespace std;

// Definition for Employee.
class Employee {
 public:
  int id;
  int importance;
  vector<int> subordinates;
};

class Solution {
 public:
  int getImportance(vector<Employee*> employees, int id) {
    unordered_map<int, Employee*> m;
    for (Employee *p : employees) {
      m[p->id] = p;
    }
    return help(id, m);
  }

  int help(int id, unordered_map<int, Employee*>& m) {
    Employee *p = m[id];
    int res = p->importance;
    for (int i : p->subordinates) {
      res += help(i, m);
    }
    return res;
  }
};
