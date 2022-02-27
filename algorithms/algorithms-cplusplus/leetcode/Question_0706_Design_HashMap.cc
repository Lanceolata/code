#include <vector>
#include <list>

using namespace std;

class MyHashMap {
 public:
  MyHashMap() {
    m_data.resize(m_size);
  }
    
  void put(int key, int value) {
    list<pair<int,int>>& list = m_data[key % m_size];
    for (pair<int,int>& val : list) {
      if (val.first == key) {
        val.second = value;
        return;
      }
    }
    list.emplace_back(key, value);
  }
    
  int get(int key) {
    list<pair<int,int>>& list = m_data[key % m_size];
    if (list.empty()) {
      return -1;
    }
    for (pair<int,int>& val : list) {
      if (val.first == key) {
        return val.second;
      }
    }
    return -1;
  }
    
  void remove(int key) {
    list<pair<int,int>>& list = m_data[key % m_size];
    list.remove_if([key](pair<int,int>& n) { return n.first == key; });
  }

 private:
  vector<list<pair<int,int>>> m_data;
  size_t m_size = 19997;
};
