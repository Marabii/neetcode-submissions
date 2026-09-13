
class KthLargest {
    private final int k;
    private final PriorityQueue<Integer> nums = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            this.nums.add(num);
            if (this.nums.size() > k)
                this.nums.poll();
        }
    }

    public int add(int val) {
        this.nums.add(val);
        if (this.nums.size() > k)
            this.nums.poll();

        return this.nums.peek();
    }
}
