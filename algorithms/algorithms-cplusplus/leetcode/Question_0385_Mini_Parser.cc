#include <stdlib.h>
#include <string>
#include <vector>
#include <stack>

using namespace std;

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
class NestedInteger {
  public:
    // Constructor initializes an empty nested list.
    NestedInteger();

    // Constructor initializes a single integer.
    NestedInteger(int value);

    // Return true if this NestedInteger holds a single integer, rather than a nested list.
    bool isInteger() const;

    // Return the single integer that this NestedInteger holds, if it holds a single integer
    // The result is undefined if this NestedInteger holds a nested list
    int getInteger() const;

    // Set this NestedInteger to hold a single integer.
    void setInteger(int value);

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    void add(const NestedInteger &ni);

    // Return the nested list that this NestedInteger holds, if it holds a nested list
    // The result is undefined if this NestedInteger holds a single integer
    const vector<NestedInteger> &getList() const;
};

class Solution {
 public:
  NestedInteger deserialize(string s) {
    if (s[0] != '[') {
      return NestedInteger(atoi(s.c_str()));
    }
    NestedInteger* cur = new NestedInteger();
    stack<NestedInteger*> st;
    for (int i = 1, j = 1; j < s.size(); j++) {
      if (s[j] == '[') {
        st.push(cur);
        cur = new NestedInteger();
        i = j + 1;
      } else if (s[j] == ']' || s[j] == ',') {
        if (i < j) {
          cur->add(NestedInteger(atoi(s.substr(i, j - i + 1).c_str())));
        }
        i = j + 1;
        if (s[j] == ']' && !st.empty()) {
          st.top()->add(*cur);
          cur = st.top();
          st.pop();
        }
      }
    }
    return *cur;
  }
};
