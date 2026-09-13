class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> heap = new PriorityQueue<>(k, (a, b) -> {
            double dis1 = euclideanDistance(a);
            double dis2 = euclideanDistance(b);
            return Double.compare(dis2, dis1);
        });

        for (int[] point : points) {
            heap.add(point);
            if (heap.size() > k)
                heap.poll();
        }

        int[][] result = new int[k][2];
        int index = 0;
        for (int[] point : heap) {
            result[index] = point;
            index++;
        }

        return result;
    }

    private static double euclideanDistance(int[] point) {
        return Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
    }
}
