#include <vector>
#include <list>
#include <algorithm>

using namespace std;

class MyHashSet {
 public:
  MyHashSet(): prime(10007), table(prime) {
  }
    
  void add(int key) {
    int h = hash(key);
    if (!contains(key)) {
      table[h].push_back(key);
    }
  }
    
  void remove(int key) {
    int h = hash(key);
	auto it = search(table[h], key);
	if (it != table[h].end()) {
      table[h].erase(it);
    }
  }
    
  bool contains(int key) {
    int h = hash(key);
    return search(table[h], key) != table[h].end();
  }

 private:
  int prime;
  vector<list<int>> table;

  int hash(int key) {
	return key % prime;
  }

  list<int>::iterator search(list<int>& list, int key) {
	return find(list.begin(), list.end(), key);
  }
};
