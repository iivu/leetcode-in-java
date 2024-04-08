import java.util.*;
import java.util.stream.Collectors;

public class Twitter {

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5); // 用户 1 发送了一条新推文 (用户 id = 1, 推文 id = 5)
        twitter.getNewsFeed(1);  // 用户 1 的获取推文应当返回一个列表，其中包含一个 id 为 5 的推文
        twitter.follow(1, 2);    // 用户 1 关注了用户 2
        twitter.postTweet(2, 6); // 用户 2 发送了一个新推文 (推文 id = 6)
        twitter.getNewsFeed(1);  // 用户 1 的获取推文应当返回一个列表，其中包含两个推文，id 分别为 -> [6, 5] 。推文 id 6 应当在推文 id 5 之前，因为它是在 5 之后发送的
        twitter.unfollow(1, 2);  // 用户 1 取消关注了用户 2
        twitter.getNewsFeed(1);  // 用户 1 获取推文应当返回一个列表，其中包含一个 id 为 5 的推文。因为用户 1 已经不再关注用户 2
    }

    private static int time = 1;
    private static int PER_PERSON_FETCH_TWEET_MAX_COUNT = 10;

    private final static class Tweet {
        public int id;
        public int belong;
        public int createAt;
        public Tweet next;

        public Tweet(int id, int belong) {
            this(id, belong, null);
        }

        public Tweet(int id, int belong, Tweet next) {
            this.id = id;
            this.belong = belong;
            this.next = next;
            this.createAt = ++time;
        }
    }

    private final Map<Integer, Tweet> timelines = new HashMap<>();
    private final Map<Integer, Set<Integer>> followsMap = new HashMap<>();

    public Twitter() {

    }

    public void postTweet(int userId, int tweetId) {
        if (!timelines.containsKey(userId)) {
            timelines.put(userId, new Tweet(tweetId, userId));
        } else {
            Tweet last = timelines.get(userId);
            timelines.put(userId, new Tweet(tweetId, userId, last));
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> follows = followsMap.computeIfAbsent(userId, k -> new LinkedHashSet<>());
        List<Tweet> userTweets = new ArrayList<>(getUserLatestTweet(userId));
        if (follows.isEmpty()) {
            return userTweets.stream().map(t -> t.id).collect(Collectors.toList());
        }
        List<List<Tweet>> tweets = new ArrayList<>();
        tweets.add(userTweets);
        for (int followeeId : follows) {
            if (followeeId == userId) {
                continue;
            }
            tweets.add(getUserLatestTweet(followeeId));
        }
        List<Tweet> sortedTweets = new ArrayList<>();
        for (List<Tweet> tweet : tweets) {
            sortedTweets = merge(sortedTweets, tweet);
        }
        return sortedTweets.subList(0, Math.min(10, sortedTweets.size())).stream().map(tweet -> tweet.id).collect(Collectors.toList());
    }

    public void follow(int followerId, int followeeId) {
        Set<Integer> follows = followsMap.computeIfAbsent(followerId, k -> new LinkedHashSet<>());
        follows.add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> follows = followsMap.computeIfAbsent(followerId, k -> new LinkedHashSet<>());
        follows.remove(followeeId);
    }

    private List<Tweet> getUserLatestTweet(int userId) {
        List<Tweet> result = new ArrayList<>();
        Tweet last = timelines.get(userId);
        if (last == null) {
            return result;
        }
        for (int i = 0; i < PER_PERSON_FETCH_TWEET_MAX_COUNT; ++i) {
            if (last != null) {
                result.add(last);
                last = last.next;
            } else {
                break;
            }
        }
        return result;
    }

    private List<Tweet> merge(List<Tweet> list1, List<Tweet> list2) {
        List<Tweet> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i).createAt > list2.get(j).createAt) {
                result.add(list1.get(i));
                i++;
            } else {
                result.add(list2.get(j));
                j++;
            }
            if (result.size() >= PER_PERSON_FETCH_TWEET_MAX_COUNT) {
                return result;
            }
        }
        if (i < list1.size()) {
            result.addAll(list1.subList(i, list1.size()));
        }
        if (j < list2.size()) {
            result.addAll(list2.subList(j, list2.size()));
        }
        return result;
    }
}
