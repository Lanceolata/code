#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
 public:
  int fourSumCount(vector<int>& A, vector<int>& B, vector<int>& C, vector<int>& D) {
    int res = 0;
    unordered_map<int, int> m;
    for(auto i : A){
      for(auto j : B){
        m[i + j]++;
      }
    }        
    for(auto i : C){
      for(auto j : D){
        if(m.count(-(i + j))){
          res += m[-(i + j)];
        }
      }
    }
    return res;
  }
};
