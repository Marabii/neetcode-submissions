class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> {
            return -Integer.compare(a, b);
        });

        for (int stone : stones) {
            heap.add(stone);
        }

        while (heap.size() >= 2) {
            int stoneX = heap.poll();
            int stoneY = heap.poll();
            int diff = Math.abs(stoneY - stoneX);

            if (diff > 0) {
                heap.add(diff);
            }
        }

        return heap.peek() == null ? 0 : heap.poll();

    }
}
