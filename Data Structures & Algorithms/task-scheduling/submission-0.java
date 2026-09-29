class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Task> heap = new PriorityQueue<>((a, b) -> {
            return -Integer.compare(a.freq, b.freq);
        });

        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            heap.add(new Task(entry.getKey(), entry.getValue()));
        }

        StringBuilder sb = new StringBuilder();

        // Handle first task separately
        Task fT = heap.poll();
        for (int i = 0; i < fT.freq; i++) {
            sb.append(fT.task);

            if (i != fT.freq - 1) {
                for (int j = 0; j < n; j++) {
                    sb.append("-");
                }
            }
        }

        while (!heap.isEmpty()) {
            Task t = heap.poll();
            int remaining = t.freq;
            int i = 1;
            while (remaining != 0) {
                if (i >= sb.length()) {
                    sb.append(t.task);
                    i += 1;
                    remaining--;
                } else if (sb.charAt(i) != '-') {
                    i++;
                } else {
                    sb.setCharAt(i, t.task);
                    i += n;
                    remaining--;
                }
            }
        }

        return sb.length();
    }

    private record Task(char task, int freq) {
    }
}
