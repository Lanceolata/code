#include <vector>

using namespace std;

class Solution {
 public:
  int maxSatisfied(vector<int>& customers, vector<int>& grumpy, int minutes) {
    int satisfied = 0, m_add_satisfied = 0, add_satisfied = 0;
    for (int i = 0; i < customers.size(); ++i) {
      satisfied += !grumpy[i] * customers[i];
      add_satisfied += grumpy[i] * customers[i];
      if (i >= minutes) {
        add_satisfied -= grumpy[i - minutes] * customers[i - minutes];
      }
      m_add_satisfied = max(m_add_satisfied, add_satisfied);
    }
    return satisfied + m_add_satisfied;
  }
};
