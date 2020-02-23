#include <unordered_map>
#include <vector>
#include <algorithm>
#include <unordered_set>

using namespace std;

class Twitter {
 public:
  /** Initialize your data structure here. */
  Twitter() {
    time = 0;
  }
    
  /** Compose a new tweet. */
  void postTweet(int userId, int tweetId) {
    tweets[userId].emplace_back(time++, tweetId);
  }
    
  /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
  vector<int> getNewsFeed(int userId) {
    std::vector<std::pair<Tweet*, Tweet*>> h;
    for (auto& u: following[userId]) {
      auto& t = tweets[u];
      if (t.size() > 0) {
        h.emplace_back(t.data(), t.data() + t.size() - 1);
      }
    }
    auto& t = tweets[userId]; // self
    if (t.size() > 0) {
      h.emplace_back(t.data(), t.data() + t.size() - 1);
    }
            
    auto f = [](const std::pair<Tweet*, Tweet*>& x, const std::pair<Tweet*, Tweet*>& y) {
      return x.second->time < y.second->time;
    };
    std::make_heap(h.begin(), h.end(), f);

    const int n = 10;
    std::vector<int> o;
    o.reserve(n);
    for (int i = 0; (i < n) && !h.empty(); ++i) {
      std::pop_heap(h.begin(), h.end(), f);

      auto& hb = h.back();
      o.push_back(hb.second->id);

      if (hb.first == hb.second--) {
        h.pop_back();
      } else {
        std::push_heap(h.begin(), h.end(), f);
      }
    }
    return o;
  }
    
  /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
  void follow(int followerId, int followeeId) {
    if (followerId != followeeId) {
      following[followerId].insert(followeeId);
    }
  }
    
  /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
  void unfollow(int followerId, int followeeId) {
    following[followerId].erase(followeeId);
  }

 private:
  struct Tweet {
    int time;
    int id;
    Tweet(int time, int id) : time(time), id(id) {}
  };

  unordered_map<int, std::vector<Tweet>> tweets; // [u] = array of tweets by u
  unordered_map<int, std::unordered_set<int>> following; // [u] = array of users followed by u

  int time;
};
