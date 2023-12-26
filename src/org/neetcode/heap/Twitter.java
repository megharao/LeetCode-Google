package org.neetcode.heap;

import java.util.*;

public class Twitter {
    Map<Integer, HashSet<Integer>> followMap;
    int count;
    Map<Integer, List<Pair>> tweetMap;

    public Twitter() {
        followMap = new HashMap<>();
        count = 0;
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if(tweetMap.containsKey(userId)) {
            List<Pair> tweets = tweetMap.get(userId);
            tweets.add(new Pair(tweetId, count));
        } else {
            List<Pair> list = new ArrayList<>();
            list.add(new Pair(tweetId, count));
            tweetMap.put(userId, list);
        }
        count++;
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> tweets = new ArrayList<>();
        PriorityQueue<PairFolloweeId> pq = new PriorityQueue<>(new Comparator<PairFolloweeId>() {
            @Override
            public int compare(PairFolloweeId o1, PairFolloweeId o2) {
                return o2.counter - o1.counter;
            }
        });
        follow(userId, userId);
        for(int followee : followMap.get(userId)) {
            if(tweetMap.containsKey(followee)) {
                int index = tweetMap.get(followee).size() - 1;
                Pair pair = tweetMap.get(followee).get(index);
                pq.add(new PairFolloweeId(pair.tweetId, pair.counter, followee, index - 1));
            }
        }
        while(!pq.isEmpty() && tweets.size() < 10) {
            PairFolloweeId pairFolloweeId = pq.poll();
            tweets.add(pairFolloweeId.tweetId);
            if(pairFolloweeId.index >= 0) {
                Pair pair = tweetMap.get(pairFolloweeId.followeeId).get(pairFolloweeId.index);
                pq.add(new PairFolloweeId(pair.tweetId, pair.counter, pairFolloweeId.followeeId, pairFolloweeId.index - 1));
            }
        }
        return tweets;
    }

    public void follow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)) {
            HashSet<Integer> followees = followMap.get(followerId);
            followees.add(followeeId);
        } else {
            HashSet<Integer> followees = new HashSet<>();
            followees.add(followeeId);
            followMap.put(followerId, followees);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)) {
            HashSet<Integer> followees = followMap.get(followerId);
            followees.remove(followeeId);
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
        System.out.println(twitter.getNewsFeed(1));  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
        twitter.follow(1, 2);    // User 1 follows user 2.
        twitter.postTweet(2, 6);
        twitter.postTweet(2, 7);// User 2 posts a new tweet (id = 6).
        System.out.println(twitter.getNewsFeed(1));  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        twitter.unfollow(1, 2);  // User 1 unfollows user 2.
        System.out.println(twitter.getNewsFeed(1));  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.
    }
}

class Pair {
    int tweetId;
    int counter;
    Pair(int tweetId, int counter) {
        this.tweetId = tweetId;
        this.counter = counter;
    }
}

class PairFolloweeId {
    int tweetId;
    int counter;

    int followeeId;

    int index;
    PairFolloweeId(int tweetId, int counter, int followeeId, int index) {
        this.tweetId = tweetId;
        this.counter = counter;
        this.followeeId = followeeId;
        this.index = index;
    }
}
