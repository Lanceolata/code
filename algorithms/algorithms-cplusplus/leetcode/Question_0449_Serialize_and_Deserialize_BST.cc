#include <string>
#include <sstream>

using namespace std;

// Definition for a binary tree node.
struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode() : val(0), left(nullptr), right(nullptr) {}
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
  TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Codec {
 public:
  // Encodes a tree to a single string.
  string serialize(TreeNode* root) {
    ostringstream out;
    serialize(root, out);
    return out.str();
  }

  // Decodes your encoded data to tree.
  TreeNode* deserialize(string data) {
    istringstream in(data);
    return deserialize(in);
  }

 private:
  void serialize(TreeNode* root, ostringstream& out) {
    if (!root) {
      out << '#' << ' ';
      return;
    }
    out << root->val << ' ';
    serialize(root->left, out);
    serialize(root->right, out);
  }

  TreeNode* deserialize(istringstream& in) {
    string val;
    in >> val;
    if (val == "#") {
      return nullptr;
    }
    TreeNode* root = new TreeNode(stoi(val));
    root->left = deserialize(in);
    root->right = deserialize(in);
    return root;
  }
};
