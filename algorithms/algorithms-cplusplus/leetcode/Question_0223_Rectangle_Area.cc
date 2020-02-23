#include <algorithm>

using namespace std;

class Solution {
 public:
  int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    long sum = (long)(C - A) * (D - B) + (long)(G - E) * (H - F);
    if (A >=G || B >= H || E >= C || F >= D) {
      return (int)sum;
    }
    return (int)(sum - (min(G, C) - max(A, E)) * (min(D, H) - max(B, F)));
  }
};
