class MinStack {
    private List<Integer> stack;

    public MinStack() {
        this.stack = new ArrayList<>();
    }

    public void push(int val) {
        this.stack.add(val);
    }

    public void pop() {
        this.stack.removeLast();
    }

    public int top() {
        return this.stack.getLast();
    }

    public int getMin() {
        return Collections.min(this.stack);
    }
}
