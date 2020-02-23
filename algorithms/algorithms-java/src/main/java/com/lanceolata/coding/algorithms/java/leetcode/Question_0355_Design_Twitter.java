package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.*;

public class Question_0355_Design_Twitter {
    class Tweet {
        int time;
        int id;

        Tweet(int time, int id) {
            this.time = time;
            this.id = id;
        }
    }

    private Map<Integer, Set<Integer>> fans = null;
    private Map<Integer, LinkedList<Tweet>> tweets = null;
    private int cnt = 0;

    /** Initialize your data structure here. */
    public Question_0355_Design_Twitter() {
        this.fans = new HashMap<>();
        this.tweets = new HashMap<>();
        this.cnt = 0;
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!fans.containsKey(userId)) {
            fans.put(userId, new HashSet<>());
        }
        fans.get(userId).add(userId);
        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new LinkedList<>());
        }
        tweets.get(userId).addFirst(new Tweet(cnt++, tweetId));
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        if (!fans.containsKey(userId)) {
            return new LinkedList<>();
        }
        PriorityQueue<Tweet> feed = new PriorityQueue<>((t1, t2) -> t2.time - t1.time);
        fans.get(userId).stream()
                .filter(f -> tweets.containsKey(f))
                .forEach(f -> tweets.get(f).forEach(feed::add));
        List<Integer> res = new LinkedList<>();
        while (feed.size() > 0 && res.size() < 10) {
            res.add(feed.poll().id);
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!fans.containsKey(followerId)) {
            fans.put(followerId, new HashSet<>());
        }
        fans.get(followerId).add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (fans.containsKey(followerId) && followeeId != followerId) {
            fans.get(followerId).remove(followeeId);
        }
    }
}
