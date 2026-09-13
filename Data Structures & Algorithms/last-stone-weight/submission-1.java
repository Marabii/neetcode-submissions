class Solution {
    public static int lastStoneWeight(int[] stones) {
        List<Integer> stonesList = new ArrayList<>();
        for (int stone : stones)
            stonesList.add(-stone);
        PriorityQueue<Integer> heap = new PriorityQueue<>(stonesList);

        while (heap.size() > 1) {
            Integer weightX = heap.poll();
            Integer weightY = heap.poll();
            if (!weightX.equals(weightY)) {
                heap.add(-Math.abs(weightX - weightY));
            }
        }

        if (heap.size() == 1)
            return -heap.poll();
        return 0;
    }
}
