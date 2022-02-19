#include <vector>

using namespace std;

class DSU {
 public:
  DSU(int size) {
    parent.resize(size);
    for (int i = 0; i < size; i++) {
      parent[i] = i;
    }
    rank.resize(size);
  }

  int find(int x) {
    if (parent[x] != x) {
      parent[x] = find(parent[x]);
    }
    return parent[x];
  }

  bool merge(int x, int y) {
    int xr = find(x), yr = find(y);
    if (xr == yr) {
      return false;
    } else if (rank[xr] < rank[yr]) {
      parent[xr] = yr;
    } else if (rank[xr] > rank[yr]) {
      parent[yr] = xr;
    } else {
      parent[yr] = xr;
      rank[xr]++;
    }
    return true;
  }

 private:
  vector<int> parent;
  vector<int> rank;
};

class Solution {
 public:
  vector<int> findRedundantConnection(vector<vector<int>>& edges) {
    DSU dsu(1000 + 1);
    for (vector<int> edge : edges) {
      if (!dsu.merge(edge[0], edge[1])) {
        return edge;
      }
    }
    return {};
  }
};
