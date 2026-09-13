class Twitter {
    private final List<User> users;
    private static int time = 0;

    public Twitter() {
        users = new ArrayList<>();
    }

    public void postTweet(int userId, int tweetId) {
        users.stream().filter(user -> user.userId == userId).findFirst().orElseGet(() -> {
            User newUser = new User(userId);
            users.add(newUser);
            return newUser;
        }).tweets.add(new Tweet(tweetId, time));

        time++;
    }

    public List<Integer> getNewsFeed(int userId) {
        Queue<Tweet> pool = new PriorityQueue<>((a, b) -> {
            return Integer.compare(b.timeStamp, a.timeStamp);
        });

        User user = users.stream().filter(u -> u.userId == userId).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        //Add user's own tweets;
        pool.addAll(user.tweets);

        //Add tweets of people they follow:
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
        User follower = users.stream().filter(user -> user.userId == followerId).findFirst().orElseGet(() -> {
            User newUser = new User(followerId);
            users.add(newUser);
            return newUser;
        });

        User followee = users.stream().filter(user -> user.userId == followeeId).findFirst()
                .orElseGet(() -> {
                    User newUser = new User(followeeId);
                    users.add(newUser);
                    return newUser;
                });

        if (!follower.peopleIFollow.contains(followee))
            follower.peopleIFollow.add(followee);
    }

    public void unfollow(int followerId, int followeeId) {
        User follower = users.stream().filter(user -> user.userId == followerId).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        User followee = users.stream().filter(user -> user.userId == followeeId).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        follower.peopleIFollow.remove(followee);
    }

    private class User {
        public int userId;
        public List<User> peopleIFollow = new ArrayList<>();
        public List<Tweet> tweets = new ArrayList<>();

        public User(int userId) {
            this.userId = userId;
        }
    }

    private record Tweet(int tweetId, int timeStamp) {

    }
}
