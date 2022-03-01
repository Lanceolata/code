#include <string>
#include <vector>
#include <unordered_set>
#include <unordered_map>

using namespace std;

class Solution {
 public:
  vector<vector<string>> accountsMerge(vector<vector<string>>& accounts) {
    for (vector<string>& account : accounts) {
      string first = account[1];
      for (int i = 2; i < account.size(); i++) {
        string email = account[i];
        adjacent[first].push_back(email);
        adjacent[email].push_back(first);
      }
    }
    vector<vector<string>> res;
    for (vector<string>& account : accounts) {
      string name = account[0];
      string first = account[1];
      if (visited.find(first) == visited.end()) {
        vector<string> mergedAccount;
        mergedAccount.push_back(name);
        dfs(mergedAccount, first);
        sort(mergedAccount.begin() + 1, mergedAccount.end());
                res.push_back(mergedAccount);
      }
    }
    return res;
  }

 private:
  unordered_set<string> visited;
  unordered_map<string, vector<string>> adjacent;

  void dfs(vector<string>& mergedAccount, string& email) {
    visited.insert(email);
    mergedAccount.push_back(email);
    for (string& neighbor : adjacent[email]) {
      if (visited.find(neighbor) == visited.end()) {
        dfs(mergedAccount, neighbor);
      }
    }
  }
};
