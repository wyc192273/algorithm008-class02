package leetcode.P20200414;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import leetcode.ListNode;

/**
 * Created by yuchen.wu on 2020-04-14
 */

public class P355 {

    static class Twitter{

        private class Tweet{
            public int id;
            public long time;

            public Tweet(int id, long time) {
                this.id = id;
                this.time = time;
            }

            public int getId() {
                return id;
            }

            public long getTime() {
                return time;
            }
        }

        private static long timstamp = 0;
        private Map<Integer, Set<Integer>> follower;
        private Map<Integer, List<Tweet>> tweetMap;

        /** Initialize your data structure here. */
        public Twitter() {
            follower = new HashMap<>();
            tweetMap = new HashMap<>();
        }

        /**
         * Compose a new tweet.
         */
        public void postTweet(int userId, int tweetId) {
            tweetMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(new Tweet(tweetId, timstamp++));
        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
            Set<Integer> follow = follower.getOrDefault(userId, new HashSet<>());
            follow.add(userId);
            List<Tweet> tweets = new ArrayList<>();
            for (int followId : follow) {
                tweets.addAll(tweetMap.getOrDefault(followId, new ArrayList<>()));
            }
            return tweets.stream().sorted(Comparator.comparing(Tweet::getTime).reversed()).map(Tweet::getId).limit(10).collect(Collectors.toList());
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            follower.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            if (!follower.containsKey(followerId)) {
                return;
            }
            Set<Integer> followeeIds = follower.get(followerId);
            followeeIds.remove(followeeId);
            if (followeeIds.size() == 0) {
                follower.remove(followerId);
            }
        }
    }

    public static void main(String[] args) {
        Twitter obj = new Twitter();
//        obj.postTweet(1,5);
//     List<Integer> param_2 = obj.getNewsFeed(1);
//     obj.follow(1,2);
//        obj.postTweet(2, 6);
//        System.out.println(obj.getNewsFeed(1));
//     obj.unfollow(1,2);
//        System.out.println(obj.getNewsFeed(1));
        obj.postTweet(1,5);
        obj.postTweet(1, 3);
        System.out.println(obj.getNewsFeed(1));
    }


}
