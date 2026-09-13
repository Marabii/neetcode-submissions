class TimeMap {
    private Map<String, List<ValueAtTimestamp>> store;

    public TimeMap() {
        this.store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<ValueAtTimestamp> values = this.store.getOrDefault(key, new ArrayList<>());
        ValueAtTimestamp newVal = new ValueAtTimestamp(value, timestamp);
        values.add(newVal);
        this.store.put(key, values);
    }

    public String get(String key, int timestamp) {
        List<ValueAtTimestamp> values = this.store.getOrDefault(key, new ArrayList<>());
        if (values.isEmpty()) {
            return "";
        }

        int left = 0;
        int right = values.size() - 1;

        String closestVal = "";

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (values.get(middle).timestamp > timestamp) {
                right = middle - 1;
            } else if (values.get(middle).timestamp < timestamp) {
                closestVal = values.get(middle).value;
                left = middle + 1;
            } else {
                return values.get(middle).value;
            }
        }

        return closestVal;
    }

    private record ValueAtTimestamp(String value, int timestamp) {

    }
}

