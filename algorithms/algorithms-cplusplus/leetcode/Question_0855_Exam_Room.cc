#include <vector>

using namespace std;

class ExamRoom {
 public:
  ExamRoom(int n) {
    N = n;
  }
    
  int seat() {
    if (L.size() == 0) {
      L.push_back(0);
      return 0;
    }
    int d = max(L[0], N - 1 - L[L.size() - 1]);
    for (int i = 1; i < L.size(); ++i) {
      d = max(d, (L[i] - L[i - 1]) / 2);
    }
    if (L[0] == d) {
      L.insert(L.begin(), 0);
      return 0;
    }
    for (int i = 1; i < L.size(); ++i) {
      if ((L[i] - L[i - 1]) / 2 == d) {
        L.insert(L.begin() + i, (L[i] + L[i - 1]) / 2);
        return L[i];
      }
    }
    L.push_back(N - 1);
    return N - 1;
  }
    
  void leave(int p) {
    for (int i = 0; i < L.size(); ++i) {
      if (L[i] == p) {
        L.erase(L.begin() + i);
      }
    }
  }

 private:
  int N;
  vector<int> L;
};
