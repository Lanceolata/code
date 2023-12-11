#include <vector>

using namespace std;

class Solution {
 public:
  vector<double> sampleStats(vector<int>& count) {
    int l = 0, r = 255, nl = 0, nr = 0,minV = 256, maxV = 0, mid1 = 0, mid2 = 0, mode = 0;
    long long sum = 0;
    while (l <= r) {
      while (count[l] == 0) {
        l++;
      }
      while (count[r] == 0) {
        r--;
      }
      if (nl < nr) {
        sum += (long long)count[l] * l;
        nl += count[l];
        if (count[l] > count[mode]) {
          mode = l;
        }
        minV = min(minV, l);
        maxV = max(maxV, l);
        mid1 = l;
        l++;
      } else {
        sum += (long long)count[r] * r;
        nr += count[r];
        if (count[r] > count[mode]) {
          mode = r;
        }
        minV = min(minV, r);
        maxV = max(maxV, r);
        mid2 = r;
        r--;
      }
    }
    double mid;
    if (nl < nr) {
      mid = mid2;
    } else if (nl > nr) {
      mid = mid1;
    } else {
      mid = (double) (mid1 + mid2) / 2;
    }
    vector<double> res;
    res.push_back(minV);
    res.push_back(maxV);
    res.push_back(1.0 * sum / (nl + nr));
    res.push_back(mid);
    res.push_back(mode);
    return res;
  }
};
