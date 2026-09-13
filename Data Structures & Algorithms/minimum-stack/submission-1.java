class MinStack {
    private List<Integer> stack;
    private List<Integer> minimums;

    public MinStack() {
        this.stack = new ArrayList<>();
        this.minimums = new ArrayList<>();
    }

    public void push(int val) {
        stack.add(val);
        int currMin = minimums.isEmpty() ? Integer.MAX_VALUE : minimums.getLast();
        if (currMin < val) {
            minimums.add(currMin);
        } else {
            minimums.add(val);
        }
    }

    public void pop() {
        stack.removeLast();
        minimums.removeLast();
    }

    public int top() {
        return stack.getLast();
    }

    public int getMin() {
        return minimums.getLast();
    }
}
