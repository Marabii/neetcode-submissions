class Twitter {
    private static int MAXIMUM_FEED_SIZE = 10;
    private static int time = 0;
    private Map<Integer, User> users;

    public Twitter() {
        this.users = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        User user = getOrCreateUser(userId);
        user.tweets.put(time, tweetId);
        user.timestamps.add(time);
        time++;
    }

    public List<Integer> getNewsFeed(int userId) {
        User user = getOrCreateUser(userId);
        List<Integer> feed = new ArrayList<>();
        int[] pointers = new int[user.followees.size() + 1];
        int i = 0;

        for (User followee : user.followees) {
            pointers[i] = followee.tweets.size() - 1;
            i++;
        }

        pointers[user.followees.size()] = user.tweets.size() - 1;

        while (feed.size() < MAXIMUM_FEED_SIZE) {
            int tweet = findLatestTweet(user.followees, user, pointers);

            if (tweet == -1)
                break;

            feed.add(tweet);
        }

        return feed;
    }

    public void follow(int followerId, int followeeId) {
        User follower = getOrCreateUser(followerId);
        User followee = getOrCreateUser(followeeId);
        follower.followees.add(followee);
    }

    public void unfollow(int followerId, int followeeId) {
        User follower = getOrCreateUser(followerId);
        User followee = getOrCreateUser(followeeId);
        follower.followees.remove(followee);
    }

    private User getOrCreateUser(int userId) {
        User user = this.users.get(userId);

        if (user != null)
            return user;

        User defaultUser = new User(userId);
        this.users.put(userId, defaultUser);

        return defaultUser;
    }

    private int findLatestTweet(Set<User> followees, User currUser, int[] pointers) {
        int timestamp = Integer.MIN_VALUE;
        int tweet = -1;
        int pointer = -1;
        int i = 0;

        for (User user : followees) {
            int lastStamp = pointers[i] >= 0 ? user.timestamps.get(pointers[i])
                    : Integer.MIN_VALUE;
            if (lastStamp > timestamp) {
                timestamp = lastStamp;
                pointer = i;
                tweet = user.tweets.get(timestamp);
            }
            i++;
        }

        int lastStamp = pointers[i] >= 0 ? currUser.timestamps.get(pointers[i])
                : Integer.MIN_VALUE;
        if (lastStamp > timestamp) {
            timestamp = lastStamp;
            pointer = i;
            tweet = currUser.tweets.get(timestamp);
        }

        if (pointer >= 0)
            pointers[pointer]--;

        return tweet;
    }

    // tweet: timestamp -> tweetId
    private class User {
        List<Integer> timestamps;
        Map<Integer, Integer> tweets;
        Set<User> followees;
        int userId;

        public User(int userId) {
            this.userId = userId;
            this.timestamps = new ArrayList<>();
            this.tweets = new HashMap<>();
            this.followees = new LinkedHashSet<>();
        }

        @Override
        public boolean equals(Object obj) {
            if (this.getClass() != obj.getClass())
                return false;
            User other = (User) obj;

            return this.userId == other.userId;
        }

        @Override
        public int hashCode() {
            return Objects.hash(userId);
        }
    }
}
