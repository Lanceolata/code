#include <vector>
#include <unordered_map>

using namespace std;

// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> neighbors;
    Node() {
        val = 0;
        neighbors = vector<Node*>();
    }
    Node(int _val) {
        val = _val;
        neighbors = vector<Node*>();
    }
    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};

class Solution {
 public:
  Node* cloneGraph(Node* node) {
    unordered_map<int, Node*> map;
    return help(node, map);
  }

  Node* help(Node* node, unordered_map<int, Node*>& map) {
    if (!node) {
      return NULL;
    }
    auto it = map.find(node->val);
    if (it != map.end()) {
      return it->second;
    }
    Node* newNode = new Node(node->val, {});
    map[node->val] = newNode;
    for (size_t i = 0; i < node->neighbors.size(); i++) {
      (newNode->neighbors).push_back(help(node->neighbors[i], map));
    }
    return newNode;
  }
};
