class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] sol = new int[k][2];
        PriorityQueue<int[]> heap = new PriorityQueue<>((p1, p2) -> {
            return -Double.compare(distance(p1[0], p1[1]), distance(p2[0], p2[1]));
        });

        for (int[] point : points) {
            heap.add(point);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int i = 0;
        for (int[] closest : heap) {
            sol[i] = closest;
            i++;
        }

        return sol;
    }

    private double distance(int x, int y) {
        return Math.sqrt(x * x + y * y);
    }
}
