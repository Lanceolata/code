#include <list>
#include <unordered_map>

using namespace std;

class LRUCache {
 public:
  LRUCache(int capacity) {
    m_capacity = capacity;
  }
                
  int get(int key) {
    auto it = m_map.find(key);
    if (it == m_map.end()) return -1;
    m_list.splice(m_list.begin(), m_list, it->second);
    return it->second->second;
  }
                    
  void put(int key, int value) {
    auto it = m_map.find(key);
    if (it != m_map.end()) {
      m_list.splice(m_list.begin(), m_list, it->second);
      it->second->second = value;
    } else {
      if (m_list.size() == m_capacity) {
        m_map.erase(m_list.back().first);
        m_list.pop_back();
      }
      m_list.emplace_front(key, value);
      m_map.emplace(key, m_list.begin());
    }
  }

 private:
  int m_capacity;
  list<pair<int, int>> m_list;
  unordered_map<int, list<pair<int, int>>::iterator> m_map;
};