class Twitter {
    private final Map<Integer, User> users;
    private static int time = 0;

    public Twitter() {
        users = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        User user = getUser(userId);
        user.tweets.add(new Tweet(tweetId, time));
        time++;
    }

    public List<Integer> getNewsFeed(int userId) {
        Queue<Tweet> pool = new PriorityQueue<>((a, b) -> {
            return Integer.compare(b.timeStamp, a.timeStamp);
        });

        User user = getUser(userId);

        // Add user's own tweets;
        pool.addAll(user.tweets);

        // Add tweets of people they follow:
        for (User followee : user.peopleIFollow) {
            if (followee.userId == userId)
                continue;
            pool.addAll(followee.tweets);
        }

        List<Integer> result = new ArrayList<>();
        while (!pool.isEmpty()) {
            Tweet tweet = pool.poll();
            if (result.size() < 10)
                result.add(tweet.tweetId);
            else
                break;
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        User follower = getUser(followerId);
        User followee = getUser(followeeId);
        follower.peopleIFollow.add(followee);
    }

    public void unfollow(int followerId, int followeeId) {
        User follower = getUser(followerId);
        User followee = getUser(followeeId);
        follower.peopleIFollow.remove(followee);
    }

    private User getUser(int userId) {
        if (users.containsKey(userId)) {
            return users.get(userId);
        } else {
            User newUser = new User(userId);
            users.put(userId, newUser);
            return newUser;
        }
    }

    private class User {
        public int userId;
        public Set<User> peopleIFollow = new HashSet<>();
        public Set<Tweet> tweets = new HashSet<>();

        public User(int userId) {
            this.userId = userId;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof User))
                return false;
            User user = (User) o;
            return this.userId == user.userId;
        }

        @Override
        public int hashCode() {
            return userId;
        }
    }

    private record Tweet(int tweetId, int timeStamp) {

    }
}
