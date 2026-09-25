public class KthLargest {
    private PriorityQueue<Integer> queue;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.queue = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a, b);
        });
        this.k = k;

        for (int num : nums) {
            this.queue.add(num);
            if (this.queue.size() > k) {
                this.queue.remove();
            }
        }
    }

    public int add(int val) {
        this.queue.add(val);
        if (this.queue.size() > k) {
            this.queue.remove();
        }
        return this.queue.peek();
    }
}